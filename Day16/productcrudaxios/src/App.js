import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import { Routes,Route } from 'react-router-dom';
import Header from './Components/Header';
import Footer from './Components/Footer';
import MainNavBar from './Components/MainNavBar';
import HomeComponent from './pages/HomeComponent';
import ProductTable from './pages/ProductTable';
import ProductList from './pages/ProductList';
import ProductForm from './pages/ProductForm';
import ProductEdit from './pages/ProductEdit';
import ProductDetails from './pages/ProductDetails';
function App() {
  return (
    <div className="App">
      <Header></Header>
      <MainNavBar></MainNavBar>
      <Routes>
        <Route path="/home" element={<HomeComponent></HomeComponent>}></Route>
        <Route path="/table" element={<ProductTable></ProductTable>}></Route>
        <Route path="/form" element={<ProductForm></ProductForm>}></Route>
        <Route path="/list" element={<ProductList></ProductList>}></Route>
        <Route path="/edit/:id" element={<ProductEdit></ProductEdit>}></Route>
        <Route path="/view/:id" element={<ProductDetails></ProductDetails>}></Route>
      </Routes>
      <Footer></Footer>
    </div>
  );
}

export default App;
