import React from 'react'
import Home from './views/home'
import Mine from './views/mine'
import Notfound from './views/404' 
import Demo from './views/demo'
import './css/style.css'

//运用h5的新特性，上线后可能需要后台做重定向的处理
// import { BrowserRouter as Router, Route } from 'react-router-dom'
//运用hash，不需额外处理
import { HashRouter as Router, Route,Switch , NavLink } from 'react-router-dom'

export default class app extends React.Component{
    render(){
        return (
            <div>
                <Router>
                <ul>
                    <li>
                        <NavLink exact  to="/"> home</NavLink>
                    </li>
                    <li>
                        <NavLink  to="/mine"> mine</NavLink>
                    </li>
                    {/* 跳转时可以携带特定的值 */}
                    <li>
                          <NavLink  to={{
                            pathname: "/demo",
                            search: "?sort=name",
                            hash: "#the-hash",
                            state: { flag: false }
                        }}> demo</NavLink>
                    </li>
                </ul>
                {/* exact 代表精准匹配 只要当路由完全一样时才匹配 */}
                    <Switch>
                    {/* 通过组件传值的方法，？代表着 */}
                        <Route exact path='/' component={ Home }/>
                        <Route path='/mine/:id?' component={ Mine }/>
                        <Route path='/demo' render={(props)=> <Demo {...props} name="LiLei"></Demo> }/>
                        <Route component={ Notfound }/>
                    </Switch>
                </Router>
            </div>
        )
    }
}
