import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import logo from '../assets/logo.webp'
import { useForm } from 'react-hook-form';
import { Link} from 'react-router-dom';

function Login(){
    const { register, handleSubmit, formState: { errors } } = useForm();
    const [isVisible, setIsVisible] = useState(false);
    const [isVisibleinvalid, setIsVisibleinvalid] = useState(false);
    const navigate = useNavigate();
    const onSubmit = (data) => {
        let userdetails = {
            mobileNumber:data.mobile,
            password:data.password
        }
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(userdetails),
            redirect: 'follow'
        };

        fetch("http://localhost:8080/login", requestOptions)
        .then(response => response.text())
        .then(result =>{
            result = JSON.parse(result);
            if(result.message == "success"){  
                navigate('/');
            }
            else if(result.message == "Invalid credentials"){
                setIsVisible(false);
                setIsVisibleinvalid(true);
            }
            else{
                setIsVisibleinvalid(false);
                setIsVisible(true);
            }
        })
        .catch(error => console.log('error', error));
    };

    const style = {
        height: '100%',
        width: '100%'
    }

    return (
        <div className="login">
            <link rel="preload" href={logo} as="image" />
            <div className="logo">
                <img src={logo} alt="logo" title="logo" fetchpriority="high" width="100%" height="100%"/>
            </div>
            <div className='user-exixts' style={{ display: isVisible ? 'block' : 'none' }}>
                <p>User Not Exists Please SignUp</p>
            </div>
            <div className='user-exixts' style={{ display: isVisibleinvalid ? 'block' : 'none' }}>
                <p>Invalid credentials</p>
            </div>
            <form onSubmit={handleSubmit(onSubmit)}>
                <h1>Login</h1>
                <div className="input-fields">
                    <label>Mobile Number</label>
                    <input maxLength={10} type='tel' inputMode="numeric" id="mobile" {...register('mobile', {required: 'Mobile number is required',pattern: {value: /^[0-9]{10}$/, message: 'Mobile number must be 10 digits'}})}/>
                    {errors.mobile && <p>{errors.mobile.message}</p>}
                </div>
                <div className="input-fields">
                    <label>Password (Atleast 8 characters)</label>
                    <input
                        id="password"
                        type="password"
                        {...register('password', {
                            required: 'Password is required',
                            minLength: {
                            value: 8,
                            message: 'Password must be at least 8 characters long'
                            },
                            pattern: {
                            value: /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/,
                            message: 'Password must contain at least one letter, one number, and one special character'
                            }
                        })}
                    />
                    {errors.password && <p>{errors.password.message}</p>}
                </div>
                <button className='register'>Submit</button>
                <div className='login-click'>
                    <span>New customer? </span>
                    <Link to="/signup"> Sign Up</Link>
                </div>
            </form>
        </div>
    )
}

export default Login