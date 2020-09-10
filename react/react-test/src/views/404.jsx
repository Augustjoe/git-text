import React from "react"
const notfound = (props)=>{
    const goBack = ()=>{
        // push是添加，将页面添加进历史中
        props.history.push('/')
        // replace 是替换history中最新的历史
        props.history.replace('/')
    }
    return (
        <div>
            404
            <button onClick={goBack}>返回首页</button>
        </div>
    )
}
export default notfound