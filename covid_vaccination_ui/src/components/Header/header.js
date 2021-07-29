import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import clsx from 'clsx';
import Typography from '@material-ui/core/Typography';
import MenuItem from '@material-ui/core/MenuItem';
import './header.css';
import { Link } from 'react-router-dom';
import MuiAppBar from '@material-ui/core/AppBar';

export const Header = (props) => {
    const classes = useStyles();

    return (
        <div>
      <AppBar position="fixed">
        <Toolbar className={classes.toolbar}>
          <div className={classes.left} />
          <Link
            variant="h6"
            underline="none"
            color="inherit"
            className={classes.title}
            href="/premium-themes/onepirate/"
          >
            {'Covid Vaccination Portal'}
          </Link>
          <div className={classes.right}>
            <Link
              color="inherit"
              variant="h6"
              underline="none"
              className={classes.rightLink}
              to="/login"
            >
              {'Sign In'}
            </Link>
            <Link
              variant="h6"
              underline="none"
              className={classes.rightLink}
              to="/signUp"
            >
              {'Sign Up'}
            </Link>
          </div>
        </Toolbar>
      </AppBar>
    </div>
        // <div className={classes.root}>
        //     <AppBar position="static" elevation={0} data-testId="header-appbar">
        //         <Toolbar data-testId="header-toolbar">
        //             <Typography
        //                 variant="h6"
        //                 style={{ marginTop: 10 }}
        //                 className={classes.title}
        //                 data-testId="header-typography"
        //             >
        //                 <Link to="/">
        //                     {/* <img
        //                         src=""
        //                         alt=""
        //                         style={{ width: 100 }}
        //                         className="logo__img"
        //                     /> */}
        //                     style={{
        //                         padding: 0,
        //                         textDecoration: 'none',
        //                         color: 'white',
        //                     }}
        //                     <MenuItem>COVID VACCINATION PORTAL</MenuItem>
        //                 </Link>
        //             </Typography>

        //             <div className={classes.headerOptions}>
        //                 <>
        //                     <Link
        //                         to="/login"
        //                         style={{
        //                             padding: 0,
        //                             textDecoration: 'none',
        //                             color: 'white',
        //                         }}
        //                     >
        //                         <MenuItem>Login</MenuItem>
        //                     </Link>
        //                     <Link
        //                         to="/signUp"
        //                         style={{
        //                             padding: 0,
        //                             textDecoration: 'none',
        //                             color: 'white',
        //                         }}
        //                     >
        //                         <MenuItem>Sign Up</MenuItem>
        //                     </Link>
        //                 </>
        //                 )

        //             </div>
        //         </Toolbar>
        //     </AppBar>
        // </div>
    );
};

export default  Header;

const useStyles = makeStyles((theme) => ({

    title: {
        fontSize: 24,
        color: theme.palette.common.black
      },
      toolbar: {
        justifyContent: 'space-between',
      },
      left: {
        flex: 1,
      },
      leftLinkActive: {
        color: theme.palette.common.white,
      },
      right: {
        flex: 1,
        display: 'flex',
        justifyContent: 'flex-end',
      },
      rightLink: {
        fontSize: 16,
        color: theme.palette.common.white,
        marginLeft: theme.spacing(3),
      },
      linkSecondary: {
        color: theme.palette.secondary.main,
      },

    // root: {
    //     fcolor: theme.palette.common.white,
    // },

    // menuButton: {
    //     marginRight: theme.spacing(2),
    // },

    // title: {
    //     [theme.breakpoints.down('xs')]: {
    //         flexGrow: 1,
    //     },
    // },

    // headerOptions: {
    //     display: 'flex',
    //     flex: 1,
    //     justifyContent: 'flex-end',
    // },
}));