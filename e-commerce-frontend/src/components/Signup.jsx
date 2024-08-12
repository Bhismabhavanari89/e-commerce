import logo from '../assets/logo.webp'
import { useForm } from 'react-hook-form';
import { Link} from 'react-router-dom';
function Signup(){
    const { register, handleSubmit, formState: { errors } } = useForm();

    const onSubmit = (data) => {
        console.log(data);
    };

    const style = {
        height: '100%',
        width: '100%'
    }


    return (
        <div className="signup">
            <div className="logo">
                <img src={logo} alt="logo" title='logo' style={style}/>
            </div>
            <form onSubmit={handleSubmit(onSubmit)}>
                <h1>Create Account</h1>
                <div className="input-fields">
                    <label>Mobile Number</label>
                    <input maxLength={10} type='tel' inputMode="numeric" id="mobile" {...register('mobile', {required: 'Mobile number is required',pattern: {value: /^[0-9]{10}$/, message: 'Mobile number must be 10 digits'}})}/>
                    {errors.mobile && <p>{errors.mobile.message}</p>}
                </div>
                <div className="input-fields">
                    <label>Name</label>
                    <input id="name" {...register('name', { required: 'Name is required' })} />
                    {errors.name && <p>{errors.name.message}</p>}
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
                    <span>Already a customer?</span>
                    <Link to="/login"> Login</Link>
                </div>
            </form>
            
            
        </div>
    )
}

export default Signup;