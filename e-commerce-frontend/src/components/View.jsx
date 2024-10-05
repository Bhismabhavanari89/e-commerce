import React, { useState } from 'react';
import Header from "./Header"
import logo from '../assets/logo.webp'
import './View.css'

function View(){
    function addCart(){
        console.log("Clicked");
        
    }
    return (
        <div>
            <Header/>
            <div className="container">
                <div className="view-mobile">
                    <div className="img-div">
                        <img src={logo} alt="" />
                        <img src={logo} alt="" />
                        <img src={logo} alt="" />
                        <img src={logo} alt="" />
                    </div>
                    <div className="main-img">
                        <img src={logo} alt="" />
                    </div>
                    <div className="item-details">
                        
                        <h1>OnePlus Nord 4 5G (Oasis Green, 8GB RAM, 128GB Storage)</h1>
                        <h3>₹23,999 <span>₹25,999</span></h3>
                        <h6>Inclusive of all taxes</h6>
                        <hr />
                        <div className='item-description'>
                            <p>About this item</p>
                        5500mAh Battery: Just 5 minutes of charging gives you 5 hours of Prime Video binging! With its massive 5500mAh battery, you'll have all the power you need to stay charged throughout the day
100W SUPERVOOC Fast Charging: With a blazing-fast 100W adaptor, you can rocket from 0 to 100% charge in just 28 minutes and power up for the entire day in under 20 minutes!
AI starts with Nord: AI Best Face, Eraser & Smart Cutout has got you covered with best pictures. Further, AI Article and Audio Summary ensures that you don't fret with long reads and stay updated effortlessly
Sleek, strong and less prone to shatter: Introducing the only metal unibody smartphone of the 5G era: the OnePlus Nord 4. Experience the slimmest Nord ever, with a sleek 0.8mm thickness! Available in three stunning colors: Mercurial Silver, Oasis Green, and Obsidian Midnight
Up to 6 years of fast & smooth experiece: OnePlus Nord 4 has been rated A by TUV SUD for 6 years of system fluency. Further, you also get 4 Android updates & 6 years of security updates for a seamless experience
Snapdragon 7+ Gen 3: The OnePlus Nord 4, driven by the cutting-edge Qualcomm Snapdragon 7+ Gen 3, transforms your device into a powerhouse for gaming and AI
4 years of peak battery capacity: The Battery Health Engine, with its intelligent AI and hardware synergy, adapts to your charging habits, extending your battery life to an impressive 4 years—even with daily charges up to 80% or more. Effortlessly monitor and adjust settings to maximize your phone's performance
                        </div>
                    </div>
                    
                </div>
                <div className='lower-btn'>
                    <button onClick={()=>addCart()}>Add to Cart</button>
                    <button>Buy Now</button>
                </div>
            </div>
        </div>
    )
}

export default View