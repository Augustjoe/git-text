import React from "react"
import {Redirect} from "react-router-dom"

const Demo = (props)=>{
    let islogin = props.location.state.flag
    console.log(props,islogin)
    return (
        <div>
            {
                islogin ?
                <div>Demo</div>
                :<Redirect to="/"></Redirect>
            }
        </div>
    )
}
export default Demo