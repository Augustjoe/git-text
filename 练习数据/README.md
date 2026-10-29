# tlias 数据库跨电脑同步

快照日期：2026-10-29。对应学习项目：`JavaTestDemo01/web-management`。

## 文件与范围

- `tlias-20261029.sql`：完整的 `tlias` 表结构和数据，包括主键、索引、自增值、字段注释和字符集。
- `tlias-20261029.manifest.json`：文件 SHA-256、各表记录数，以及恢复校验结果。

| 表 | 记录数 |
| --- | ---: |
| `dept` | 6 |
| `emp` | 26 |
| `emp_expr` | 2 |

源 MySQL 版本为 `26.7.0`，SQL 文件使用 UTF-8 编码。已在独立临时库中实际导入，三张表的记录数和扩展表校验值均与源库一致，临时库随后删除。其他 MySQL 版本尚未单独验证。

SQL 包含应用内员工账号、姓名、手机号和密码字段。用户已确认这些全部是练习数据，同意按原样上传至公开仓库。文件不包含 MySQL 用户创建或授权语句，也不包含项目的数据库连接配置；导入后仍使用另一台电脑自己的 MySQL 登录信息。

本目录的 `.gitattributes` 保留 SQL 文件原始字节，避免 Git 在不同电脑上转换换行符，保证文件 SHA-256 可以与清单一致核对。

## 晚上在另一台电脑操作

### 1. 同步仓库

在另一台电脑已有的仓库根目录打开终端，执行：

```powershell
git pull --ff-only
```

如果还没有仓库，先克隆：

```powershell
git clone https://github.com/Augustjoe/git-text.git
cd git-text
```

### 2. 确认导入目标

SQL 内包含 `CREATE DATABASE IF NOT EXISTS tlias`、`USE tlias` 和各表的 `DROP TABLE IF EXISTS`。**导入会重建 `tlias` 中的 `dept`、`emp`、`emp_expr` 三张同名表，并用快照数据替换其内容。**

如果另一台电脑已有需要保留的 `tlias` 数据，先通过数据库工具备份，或在终端另存备份：

```powershell
mysqldump -u root -p --single-transaction --no-tablespaces --set-gtid-purged=OFF --databases tlias --result-file=tlias-before-import.sql
```

这里只是给另一台电脑生成备份的示例命令。本次没有在另一台电脑执行任何操作。`root` 应替换为那台电脑实际使用的 MySQL 用户名。

### 3. 导入 SQL

先启动另一台电脑的 MySQL 服务，然后在仓库根目录执行以下 Windows 命令，并按提示输入那台电脑的 MySQL 密码：

```powershell
cmd /c "mysql --default-character-set=utf8mb4 -u root -p < 练习数据\tlias-20261029.sql"
```

这里由 Windows 的命令解释器把文件直接送给 MySQL，避免通过 PowerShell 文本管道重新编码 SQL。若提示找不到 `mysql`，使用本机 `mysql.exe` 的完整路径，或把 MySQL 的 `bin` 目录加入 PATH。

也可以在 IDEA / DataGrip 的数据库工具中打开该 SQL 文件，选择另一台电脑的本机 MySQL 连接，执行整个文件。先确认连接目标正确，再执行文件中的建表和数据语句。

### 4. 核对结果

导入完成后，在数据库查询窗口执行：

```sql
SELECT 'dept' AS table_name, COUNT(*) AS row_count FROM tlias.dept
UNION ALL
SELECT 'emp', COUNT(*) FROM tlias.emp
UNION ALL
SELECT 'emp_expr', COUNT(*) FROM tlias.emp_expr;
```

预期数量分别为 `6`、`26`、`2`。再核对项目 `application.yml` 中的数据库地址、用户名和密码是否对应另一台电脑的本机 MySQL，然后启动项目测试接口。

## 相关知识点

- Git 同步的是仓库中的文件，不会自动复制正在运行的 MySQL 数据库。
- 本次通过 `mysqldump` 把库对象定义和表数据转换为 SQL 文件，再由另一台电脑的 MySQL 执行 SQL 完成恢复。工具说明见 [MySQL 官方文档](https://dev.mysql.com/doc/refman/8.4/en/mysqldump.html)。
- 自增主键及员工与部门、经历之间的关联 ID 均随快照保留。
- 这是 2026-10-29 的一次快照。此后修改数据库数据，需要重新导出并上传，另一台电脑才会得到新的数据库内容。
