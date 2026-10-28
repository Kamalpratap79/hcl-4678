import React, { useState } from 'react'

function Registration() {
const[empid,setempid]=useState();
const[name,setname]=useState();
const[designation,setDesignation]=useState();
const[techStack,setTechStack]=useState();
const[email,setEmail]=useState();
const[password,setPassword]=useState();


async function sendData(e){

try{
  e.preventDefault();                
  const server=await fetch("http://localhost:8080/v1/user/addemp",{
                    method:'Post',
                    body:JSON.stringify({empid,name,email,designation,password,techStack}),
                    headers:{"Content-Type":"application/json"}
                  });

                  const statue=await server.text();
                  alert(statue);

}catch(e){
 console.log(e)
}
}


  return (
    <div>

<form>

 <div className="form-group">
    <label htmlFor="exampleInputEmail1">empid</label>
    <input type="number" onChange={(e)=>setempid(e.target.value)} className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter emp_id" required />
  
  </div>

 <div className="form-group">
    <label htmlFor="exampleInputEmail1">Name</label>
    <input type="text" onChange={(e)=>setname(e.target.value)} className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name" required />
    
  </div>


  <div className="form-group">
    <label htmlFor="exampleInputEmail1">Email address</label>
    <input type="email" onChange={(e)=>setEmail(e.target.value)} className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" />
    <small id="emailHelp" className="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>


<div className="form-group">
    <label htmlFor="exampleInputEmail1">Designation</label>
    <input type="text" onChange={(e)=>setDesignation(e.target.value)} className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter deisgnation" required />
    
  </div>

<div className="form-group">
    <label htmlFor="exampleInputEmail1">Tech stack</label>
    <input type="text" onChange={(e)=>setTechStack(e.target.value)} className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Tech stack like test Engineer, Java FSD etc" required />
    
  </div>


  <div className="form-group">
    <label htmlFor="exampleInputPassword1">Password</label>
    <input type="password" onChange={(e)=>setPassword(e.target.value)} className="form-control" id="exampleInputPassword1" placeholder="Password" required />
  </div>
  
  <button type="submit" onClick={sendData} className="btn btn-primary">Register</button>
</form>

    </div>
  )
}

export default Registration