import React, {useState,useEffect} from 'react'
import axios from 'axios'
import _ from 'lodash';

export default function UpdateUser() {

  const [posts, setstate] = useState([])

    useEffect(() => {
      console.log('posts', posts);
      if(_.isEmpty(posts)) {
        axios.get(`http://localhost:8080/api/user`)
        .then(res => {
          
          const posts = res.data;
          setstate( posts );
         
        })
      }
    },[posts])

    // Update the state after input values are edited
    const updateRow=(i,event)=>{
      console.log('posts before-----', posts);
      console.log('index', i);
      console.log('event', event);
      
      var rPosts = [ ...posts ]
      rPosts[i][event.target.name] = event.target.value;
      // let statusCopy = Object.assign({}, posts);
      // console.log('statusCopy', statusCopy);
      // statusCopy[index][event.target.attributes.name] = event.target.value;
      setstate(rPosts);

      
      console.log('posts after update---', posts);
    }

    const deleteRow=(id,e)=>{
      console.log(id);
      axios.delete(`http://localhost:8080/api/user/${id}`)
        .then(res => {
          console.log(res);
          console.log(res.data);
          
          setstate(posts.filter(item => item.id !== id));
        })
    }

    // API call to update the values to database
    const updateOne=(id, e, i)=>{
      console.log('ssn to update-----', id);
      console.log('index-------', i);
      let intId = parseInt(id);
      try {
        axios.put(`http://localhost:8080/api/user/${intId}`, posts[i]);
      }
      catch(error){
        console.log('Error while Updating user-----', error);
      }
    }

    return (
        <div>
         
    
        <table className="table table-bordered">
            <thead>
              <tr>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Phone number</th>
                  <th>SSN</th>
              </tr>
            </thead>
  
            <tbody>
              {posts.map((post, index) => (
                <tr>
                  <td contentEditable='true'><input type="text" name="name" value={post.name} onChange={updateRow.bind(this, index)}/></td>
                  {/* <td contentEditable='true'>{post.name}</td> */}
                  <td contentEditable='true'>{post.email}</td>
                  <td contentEditable='true'>{post.phone_number}</td>
                  <td contentEditable='true'>{post.ssn}</td>
                  <td>
                    <button className="btn btn-danger" onClick={(e) => deleteRow(post.ssn, e)}>Delete</button>
                    <button className="btn btn-danger" onClick={(e) => updateOne(post.ssn, e, index)} >Update</button>
                  </td>
                </tr>
              ))}
            </tbody>
  
        </table>
      </div>
    )
}

// axios.delete(`http://localhost:8080/api/user/${id}`)
//         .then(res => {
//           console.log(res);
//           console.log(res.data);
          
//           setstate(posts.filter(item => item.id !== id));
//         })