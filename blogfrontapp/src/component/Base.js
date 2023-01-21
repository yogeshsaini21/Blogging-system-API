import CustomNavbar from "./CustomNavbar";
import Footer from "./Footer";

function Base({title="Welcome to our website" , children}){

    return (
        <div className="container-fluid p-0 m-0" >
           <CustomNavbar/>
            {children}

            <Footer/>

        </div>
    )
}

export default Base;