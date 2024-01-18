import React, {useState}from 'react'
import {useNavigate} from 'react-router-dom';
import ProductService from '../service/ProductService';
export default function ProductForm() {
  const[formdetails,setformdetails]=useState({pid:"",pname:"",qty:"",price:""})
  const navigate=useNavigate();
  const addproduct=()=>{
    if(formdetails.pid==="" || formdetails.pname===""||formdetails.qty==="" || formdetails.price===""){
       alert("pls fill all the fieds");
       return 
    }
    ProductService.addProduct(formdetails)
    .then((result)=>{
      console.log(result.data);
      //clear the form
      setformdetails({pid:"",pname:"",qty:"",price:""});
      navigate("/table")
    })
    .catch((err)=>{
      console.log("error occured",err);
    })
  }
  return (
    <div>
      <form>
  <div className="form-group">
    <label htmlFor="pid">Product Id:</label>
    <input type="text" className="form-control" id="pid" name="pid"
      value={formdetails.pid}
      onChange={(event)=>{setformdetails({...formdetails,pid:event.target.value})}}
    />
    
  </div>
  <div className="form-group">
    <label htmlFor="pname">Product Name</label>
    <input type="text" className="form-control" id="pname" name="pname"
      value={formdetails.pname}
      onChange={(event)=>{setformdetails({...formdetails,pname:event.target.value})}}
    />
  </div>
  <div className="form-group">
    <label htmlFor="qty">Product Quantity</label>
    <input type="text" className="form-control" id="qty" name="qty"
      value={formdetails.qty}
      onChange={(event)=>{setformdetails({...formdetails,qty:event.target.value})}}
    />
    
  </div>
  <div className="form-group">
    <label htmlFor="price">Product Price</label>
    <input type="text" className="form-control" id="price" name="price"
      value={formdetails.price}
      onChange={(event)=>{setformdetails({...formdetails,price:event.target.value})}}
    />
  </div>
  <button type="button" className="btn btn-primary" onClick={addproduct}>Add Product</button>
</form>
    </div>
  )
}
