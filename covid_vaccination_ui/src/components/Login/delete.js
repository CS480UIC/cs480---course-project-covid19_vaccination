import React, { useEffect, useState } from "react";
import { Button, CssBaseline, TextField, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';
import axios from 'axios';

/*export default function Delete() {
  
    const classes = useStyles();
    const [state, setState] = useState({
        ssn: "",
      });

      const handleInputChange = (event) => {
        setState((prevProps) => ({
          ...prevProps,
          [event.target.name]: event.target.value
        }));
      };



      var id=parseInt(state.ssn)
      const url="http://localhost:8080/api/user/${id}"
      const handleSubmit = (event) => {
        event.preventDefault();
        Axios.delete (url)
        .then(res =>{
          console.log(res)
        })
        
      };
      var data
      const handleGet=(event)=>{
        event.preventDefault();
        Axios.get(`http://localhost:8080/api/user`)
        .then(res => {
            data=res
          console.log(data["data"][0])
        })
      }
  
    return (
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <div className={classes.paper}>
        <Typography color='primary' display='block' component="h1" variant="h5">
            Sign up
          </Typography>
          <form className={classes.form} noValidate>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="fname"
                  name="ssn"
                  variant="outlined"
                  required
                  fullWidth
                  id="ssn"
                  label="ssn"
                  onChange={handleInputChange}
                  autoFocus
                />
              </Grid>
              </Grid>
              <Button
              onClick={handleSubmit}
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className={classes.submit}
            >
              submit
            </Button>
            <Button
              onClick={handleGet}
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className={classes.submit}
            >
              get all users
            </Button>
          </form>
        </div>
        <table>
  <tr>
    <th>Firstname</th>
    <th>email</th>
  </tr>
  <tr>
  <td><ul>${data.data.map(email => `<li>${email}</li>`).join("")}</ul></td>
    <td>Jackson</td>
  </tr>
</table> 
      </Container>
    );
  }

  const useStyles = makeStyles((theme) => ({

    paper: {
        marginTop: theme.spacing(15),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },

    form: {
        width: '100%',
        marginTop: theme.spacing(2),
    },

    submit: {
        margin: theme.spacing(3, 0, 3),
    },
}));*/
export default class PostList extends React.Component {
    state = {
      posts: []
    }
    
    componentDidMount() {
      axios.get(`http://localhost:8080/api/user`)
        .then(res => {
          
          const posts = res.data;
          
          this.setState({ posts });
          console.log(posts)
        })
    }
    
    deleteRow(id, e){
        console.log(id)
      axios.delete(`http://localhost:8080/api/user/${id}`)
        .then(res => {
          console.log(res);
          console.log(res.data);
          const posts = this.state.posts.filter(item => item.id !== id);
          this.setState({ posts });
        })
    
    }
    
    render() {
      return (
        <div>
          <h1>React Axios Delete Request Example - www.codechief.org</h1>
    
          <table className="table table-bordered">
              <thead>
                <tr>
                    <th>Name</th>
                    <th>email</th>
                </tr>
              </thead>
    
              <tbody>
                {this.state.posts.map((post) => (
                  <tr>
                    <td>{post.name}</td>
                    <td>{post.email}</td>
                    <td>
                      <button className="btn btn-danger" onClick={(e) => this.deleteRow(post.ssn, e)}>Delete</button>
                    </td>
                  </tr>
                ))}
              </tbody>
    
          </table>
        </div>
      )
    }
  } 