import logo from '../assets/logo.webp'
import search from '../assets/search.png'
import React, { useState } from 'react';
import './Header.css'
function Header(){
    const [isleveloneHovered, setLevelOneHovered] = useState(false);
    const [isleveltwoHovered, setIsLevelTwoHovered] = useState(false);
    const [islevelthreeHovered, setIsLevelThreeHovered] = useState(false);
    const [showsearchfield, setShowSearchField] = useState(false);
    return(
        <div>
            <header>
                <div className="nav">
                    <div className="left">
                        <a href=""><img src={logo} alt="logo" title="logo" fetchpriority="high" width="100%"
                                height="100%" /></a>
                    </div>
                    <div className="middle">
                        <div onMouseEnter={()=>{
                            setLevelOneHovered(false)
                            setIsLevelTwoHovered(false)
                            setIsLevelThreeHovered(false)
                        }}>
                            <a href="/view?mobile=all">All Mobiles</a>
                        </div>
                        <div onMouseEnter={()=>{
                            setLevelOneHovered(true)
                            setIsLevelTwoHovered(false)
                            setIsLevelThreeHovered(false)
                        }}>
                            <a href="/view?mobile=iphone">Iphone</a>
                            <div className='electronics' style={{ display: isleveloneHovered ? 'block' : 'none' }} onMouseLeave={() => setLevelOneHovered(false)}>
                                <div className='elec-inner'>
                                    <div><a href="/view?mobile=iphone15">15 Series</a></div>
                                    <div><a href="/view?mobile=iphone14">14 Series</a></div>
                                    <div><a href="/view?mobile=iphone13">13 Series</a></div>
                                    <div><a href="/view?mobile=otheriphone">Other Series</a></div>
                                </div>
                            </div>
                        </div>
                        <div onMouseEnter={()=>{
                            setIsLevelTwoHovered(true)
                            setLevelOneHovered(false)
                            setIsLevelThreeHovered(false)
                        }} >
                            <a href="/view?mobile=Samsung">Samsung</a>
                            <div className='electronics' style={{ display: isleveltwoHovered ? 'block' : 'none' }} onMouseLeave={() => setIsLevelTwoHovered(false)}>
                                    <div className='elec-inner'>
                                        <div><a href="/view?mobile=Samsungs24">Samsung S24</a></div>
                                        <div><a href="/view?mobile=Samsungs23">Samsung S23</a></div>
                                        <div><a href="/view?mobile=Samsung22">Samsung S22</a></div>
                                        <div><a href="/view?mobile=otherSamsung">Other Series</a></div>
                                    </div>
                                </div>
                            </div>
                        <div onMouseEnter={()=>{
                            setIsLevelThreeHovered(true)
                            setLevelOneHovered(false)
                            setIsLevelTwoHovered(false)
                        }}>
                            <a href="/view?mobile=Realme">Realme</a>
                            <div className='electronics' style={{ display: islevelthreeHovered ? 'block' : 'none' }} onMouseLeave={() => setIsLevelThreeHovered(false)}>
                                <div className='elec-inner'>
                                    <div><a href="/view?mobile=RealmeGT3">Realme GT 3</a></div>
                                    <div><a href="/view?mobile=RealmeGT2PRO">Realme GT 2 Pro</a></div>
                                    <div><a href="/view?mobile=Realme11PRO+">Realme 11 Pro+</a></div>
                                    <div><a href="/view?mobile=OtherRealme">Other Series</a></div>
                                </div>
                            </div>
                        </div>
                        <div onMouseEnter={()=>{
                            setLevelOneHovered(false)
                            setIsLevelTwoHovered(false)
                            setIsLevelThreeHovered(false)
                        }}>
                            <a href="/view?mobile=Accessories">Accessories</a>
                        </div>
                    </div>
                    <div className='right'>
                        <input type="text" style={{display: showsearchfield ? 'block':'none'}}/>
                        <svg width="20" height="20" viewBox="0 0 17 18" className="" xmlns="http://www.w3.org/2000/svg" onClick={()=>{setShowSearchField(true)}} style={{display: showsearchfield ? 'none':'block'}}>
                            <g fill="#2874F1" fillRule="evenodd">
                                <path className="EwE-Fa"
                                    d="m11.618 9.897l4.225 4.212c.092.092.101.232.02.313l-1.465 1.46c-.081.081-.221.072-.314-.02l-4.216-4.203">
                                </path>
                                <path className="EwE-Fa"
                                    d="m6.486 10.901c-2.42 0-4.381-1.956-4.381-4.368 0-2.413 1.961-4.369 4.381-4.369 2.42 0 4.381 1.956 4.381 4.369 0 2.413-1.961 4.368-4.381 4.368m0-10.835c-3.582 0-6.486 2.895-6.486 6.467 0 3.572 2.904 6.467 6.486 6.467 3.582 0 6.486-2.895 6.486-6.467 0-3.572-2.904-6.467-6.486-6.467">
                                </path>
                            </g>
                        </svg>
                        <a href="/signup">Sign In</a>
                        <a href="">Orders</a>
                        <a href="">Cart</a>
                    </div>
                </div>
            </header>
            <div className='Men' style={{display:'none'}}>
                <a href="">Clothing</a>
                <a href="">Shoes</a>
            </div>
        </div>
    )
}

export default Header