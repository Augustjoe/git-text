create table emp_expr (
                          id int unsigned primary key auto_increment comment 'ID 主键',
                          begin date comment '开始时间',
                          end date comment '结束时间',
                          company varchar(50) comment '公司名称',
                          job varchar(50) comment '工作名称',
                          emp_id int unsigned comment  '员工ID'
)
