import LoginPage from "../Page/Manager/LoginPage";
import SignUpPage from "../Page/Manager/SignUpPage";


const ManagerRoute = [
    {
        path : "/manager/login",
        component : LoginPage,
        exact : true
    },
    {
        path : "/manager/signup",
        component : SignUpPage,
        exact : true
    }
]

export default ManagerRoute;