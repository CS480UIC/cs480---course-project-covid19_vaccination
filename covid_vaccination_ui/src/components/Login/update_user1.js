import React, {useState,useEffect} from 'react'
import axios from 'axios'
export default function UpdateUser() {

  const [posts, setstate] = useState([])

    useEffect(() => {
        axios.get(`http://localhost:8080/api/user`)
        .then(res => {
          
          const posts = res.data;
          setstate( posts );
         
        })
    },[posts])

    const deleteRow=(id,e)=>{
      console.log(id)
      axios.delete(`http://localhost:8080/api/user/${id}`)
        .then(res => {
          console.log(res);
          console.log(res.data);
          
          setstate(posts.filter(item => item.id !== id));
        })
    }

    return (
        <div>
         
    
        <table className="table table-bordered">
            <thead>
              <tr>
                  <th>Name</th>
                  <th>email</th>
              </tr>
            </thead>
  
            <tbody>
              {posts.map((post) => (
                <tr>
                  <td contentEditable='true'>{post.name}</td>
                  <td contentEditable='true'>{post.email}</td>
                  <td>
                    <button className="btn btn-danger" onClick={(e) => deleteRow(post.ssn, e)}>Delete</button>
                    <button className="btn btn-danger">Update</button>
                  </td>
                </tr>
              ))}
            </tbody>
  
        </table>
      </div>
    )
}
