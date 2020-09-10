import React from 'react'
import With from "./withRouter"

const mine = (props)=>{
    const name = new URLSearchParams(props.location.search)
    console.log(name.get("name"),props)
    return (
        <div>Mine
            <With/>

        </div>
    )
}
export default mine