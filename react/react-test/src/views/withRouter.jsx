import React from "react"
import {withRouter} from "react-router-dom"
import {Prompt} from "react-router-dom"

class WithRouter extends React.Component{
    constructor(){
        super()
        this.state={
            value:''
        }
    }
    render(){
        console.log(this.props)
        return (
            <div>
                withRouter
                {/* when中只能传入布尔值 所以有！！将其变成布尔值 */}
                <Prompt when={ !!this.state.value} message ="are you sure?"></Prompt>
                <input type="text" value={this.state.value} onChange={(e) =>this.setState({value:e.target.value})}/>
            </div>
        )
    }
}

export default withRouter(WithRouter)