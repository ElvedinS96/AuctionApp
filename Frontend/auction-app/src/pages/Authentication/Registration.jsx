import React from "react";
import GenericField from "../../Components/FormField/GenericField"
import { handleFieldChange } from "../index.jsx"
import axios from "axios"


const Registration = props => {
    const [user, setUser] = React.useState({
        firstName: "",
        lastName: "",
        email: "",
        password: ""
    })
    let url = props.baseUrl + "/user"

    return (
        <div>
            <GenericField id={"firstName"} name={"firstName"} label={"First Name"} type={"text"} onChange={(e) => handleFieldChange(e, setUser)} />
            <GenericField id={"lastName"} name={"lastName"} label={"Last Name"} type={"text"} onChange={(e) => handleFieldChange(e, setUser)} />
            <GenericField id={"email"} name={"email"} label={"Email"} type={"text"} onChange={(e) => handleFieldChange(e, setUser)} />
            <GenericField id={"password"} name={"password"} label={"Password"} type={"text"} onChange={(e) => handleFieldChange(e, setUser)} />
            <button type={"button"} onClick={() => handleRegisterClick(user)} >REGISTER</button>
        </div>
    )

    function handleRegisterClick(user) {

        axios.post(url, user)
            .then(response => {
                //TODO Handle response
                console.log(response)
            })
            .catch(error => {
                //TODO handle error
                console.log(error)
            })
    }

}

export default Registration