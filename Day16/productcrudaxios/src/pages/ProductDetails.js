import React,{useEffect,useState} from 'react'
import { useParams,Link } from 'react-router-dom'
import ProductService from '../service/ProductService'
export default function ProductDetails() {
    const params=useParams();
    const[formdetails,setformdetails]=useState({pid:"",pname:"",qty:"",price:""})
    useEffect(()=>{
        console.log("id:"+params.id);
        ProductService.getById(params.id)
        .then((result)=>{
            setformdetails({...result.data})
        })
        .catch((err)=>{
            console.log("error occured",err)
        })
    },[])
  return (
    <div>
        <div class="card">
  <div class="card-body">
    <h5 class="card-title">Product Information</h5>
    <h6 class="card-subtitle mb-2 text-muted">{formdetails.pid}---{formdetails.pname}</h6>
    <p class="card-text">{formdetails.price}----{formdetails.qty}</p>
    
  </div>
  <Link to="/table">
  <button type="button" name="btn" id="btn">Back</button>
  </Link>
</div>
    </div>
  )
}
