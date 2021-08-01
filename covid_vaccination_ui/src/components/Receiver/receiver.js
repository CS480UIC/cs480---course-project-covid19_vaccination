import React, { useEffect, useState } from "react";
import { Button, CssBaseline, TextField, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';
import Axios from 'axios';
import { useHistory } from "react-router-dom";
import { NavLink } from 'react-router-dom'
import {
  MuiPickersUtilsProvider,
  KeyboardDatePicker
} from '@material-ui/pickers';
import DateFnsUtils from '@date-io/date-fns';
import DatePicker from "react-datepicker";


export default function Receiver() {
  const url="http://localhost:8080/api/receiver"
    const classes = useStyles();
    const [state, setState] = useState({
        receiverId: "",
        userId: "",
        vaccineId: "",
        centerId:"",
        receive_date:"",
      });

    const [date, setdate] = useState('2021-07-01')

      const handleInputChange = (event) => {
        setState((prevProps) => ({
          ...prevProps,
          [event.target.name]: event.target.value
        }));
      };

      /*const handleDateChange=(date) => {
          setdate(date)

          console.log(typeof(date.date))
      }*/

      const handleSubmit = (event) => {
        event.preventDefault()
        console.log(state.receive_date)
        console.log(state.userId)
        Axios.post(url,{
          id: state.receiverId,
          user_id: parseInt(state.userId),
          vaccine_id:parseInt(state.vaccineId),
          center_id: parseInt(state.centerId),
          receive_date: state.receive_date
        })
        .then(res =>{
        //   this.props.history.push("/home"); 
       // window.location.href = '/home';
        })
        
      };
      
  
    return (
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <div className={classes.paper}>
        <NavLink to="/update_receiver"> Show all receivers </NavLink>
        <Typography color='primary' display='block' component="h1" variant="h5">
            Receiver
          </Typography>
          <form className={classes.form} noValidate>
          <MuiPickersUtilsProvider utils={DateFnsUtils}>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  name="receiverId"
                  variant="outlined"
                  fullWidth
                  id="receiverId"
                  label="receiver Id"
                  onChange={handleInputChange}
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant="outlined"
                  fullWidth
                  id="userId"
                  label="user Id"
                  name="userId"
                  onChange={handleInputChange}
                 

                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  
                  fullWidth
                  id="vaccineId"
                  label="vaccine Id"
                  name="vaccineId"
                  onChange={handleInputChange}
                  
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
               
                  fullWidth
                  name="centerId"
                  label="centerId"
                  id="centerId"
                  onChange={handleInputChange}
                />
              </Grid>
              <Grid item xs={12}>
              <TextField
                  variant="outlined"
               
                  fullWidth
                  name="receive_date"
                  label="vaccination date {yyyy/mm/dd}"
                  id="receive_date"
                  onChange={handleInputChange}
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
            </MuiPickersUtilsProvider>
          </form>

          
        </div>
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
}));