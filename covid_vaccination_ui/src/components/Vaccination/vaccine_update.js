import React, { useEffect, useState } from "react";
import { Button, CssBaseline, TextField, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';
import axios from 'axios';
export default class PostList extends React.Component {
    state = {
      posts: [],
      values: [],
      vaccine_name:"",
      dose:""
    }

    


    
    componentDidMount() {
      axios.get(`http://localhost:8080/api/vaccine`)
        .then(res => {
          
          const posts = res.data;
          
          this.setState({ posts });
          console.log(posts)
        })
    }
    
    deleteRow(id, e){
        console.log(id)
      axios.delete(`http://localhost:8080/api/vaccine/${id}`)
        .then(res => {
          console.log(res);
          console.log(res.data);
          const posts = this.state.posts.filter(item => item.id !== id);
          this.setState({ posts });
        })
    
    }

    updateRow(i, event){
      console.log('i', i);
      var rPosts = { ...this.state.posts };
      rPosts[i][event.target.name] = event.target.value;
      console.log('rPosts after update------', rPosts);
      this.setState(rPosts);

    
    }

    updateOne(id, e, i){
      console.log('id to update-----', id);
      console.log('index-------', i);
      let intId = parseInt(id);
      try {
        axios.put(`http://localhost:8080/api/vaccine/${id}`, this.state.posts[i]);
      }
      catch(error){
        console.log('Error while Updating user-----', error);
      }
    }
    
    render() {
      return (
        <div>
         
    
          <table className="table table-bordered">
              <thead>
                <tr>
                    <th>Name</th>
                    <th>doses</th>
                    <th>type</th>
                </tr>
              </thead>
    
              <tbody>
                {this.state.posts.map((post, index) => (
                  <tr>
                    <td contentEditable='true'><input type="text" name="vaccine_name" value={post.vaccine_name} onChange={this.updateRow.bind(this, index)}/></td>
                    <td contentEditable='true'>{post.vaccine_name}</td>
                    <td contentEditable='true'>{post.doses}</td>
                    <td contentEditable='true'><input type="text" name="type" value={post.type} onChange={this.updateRow.bind(this, index)}/></td>
                    <td>
                      <button className="btn btn-danger" onClick={(e) => this.deleteRow(post.id, e)}>Delete</button>
                      <button className="btn btn-danger" onClick={(e) => this.updateOne(post.id, e, index)}>Update</button>
                    </td>
                  </tr>
                ))}
              </tbody>
    
          </table>
        </div>
      )
    }
  } 