import React, { useState,useEffect } from 'react'
import {Link} from 'react-router-dom'
import ProductService from '../service/ProductService';
export default function ProductTable() {
  const [plist,setplist]=useState([]);
  const fetchdata=()=>{
    ProductService.getAllproducts()
     .then((result)=>{
        console.log(result.data);
        setplist([...result.data])
     })
     .catch((err)=>{
        console.log("error occured",err)
     })
  }
  useEffect(()=>{
     fetchdata()

  },[])
 const deleteProduct=(pid)=>{
  ProductService.deleteProduct(pid)
  .then((result)=>{
    console.log(result.data);
    fetchdata()
  })
  .catch(()=>{})

 }

  return (
    <div>
    <br></br>
    <Link to="/form">
       <button type="button" name="btn" id="btn" className="btn btn-success"> Add new Product</button>
    </Link>
        <table className="table table-striped">
  <thead>
    <tr>
      <th scope="col">Product id</th>
      <th scope="col">productName</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
      <th>action</th>
    </tr>
  </thead>
  <tbody>
    {plist.map((ob)=><tr>
      <td >{ob.pid}</td>
      <td>{ob.pname}</td>
      <td>{ob.qty}</td>
      <td>{ob.price}</td>
      <td> 

        <button type="button" name="btn" id="delete"  className="btn btn-danger" onClick={()=>{deleteProduct(ob.pid)}}>delete</button>&nbsp;&nbsp;&nbsp;
        <Link to={`/edit/${ob.pid}`} state={{pdata:ob}}>
        <button type="button" name="btn" id="edit" className="btn btn-primary">edit</button>&nbsp;&nbsp;&nbsp;
        </Link>
        <Link to={`/view/${ob.pid}`}>
        <button type="button" name="btn" id="view" className="btn btn-info">view</button>
        </Link>
      </td>
    </tr>)}
    
  </tbody>
</table>
    </div>
  )
}
