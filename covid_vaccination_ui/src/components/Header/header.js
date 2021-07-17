import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import MenuItem from '@material-ui/core/MenuItem';
import './header.css';
import { Link } from 'react-router-dom';

export const Header = (props) => {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <AppBar position="static" elevation={0} data-testId="header-appbar">
                <Toolbar data-testId="header-toolbar">
                    <Typography
                        variant="h6"
                        style={{ marginTop: 10 }}
                        className={classes.title}
                        data-testId="header-typography"
                    >
                        <Link to="/">
                            {/* <img
                                src=""
                                alt=""
                                style={{ width: 100 }}
                                className="logo__img"
                            /> */}
                            style={{
                                padding: 0,
                                textDecoration: 'none',
                                color: 'white',
                            }}
                            <MenuItem>COVID VACCINATION PORTAL</MenuItem>
                        </Link>
                    </Typography>

                    <div className={classes.headerOptions}>
                        <>
                            <Link
                                to="/login"
                                style={{
                                    padding: 0,
                                    textDecoration: 'none',
                                    color: 'white',
                                }}
                            >
                                <MenuItem>Login</MenuItem>
                            </Link>
                            <Link
                                to="/signUp"
                                style={{
                                    padding: 0,
                                    textDecoration: 'none',
                                    color: 'white',
                                }}
                            >
                                <MenuItem>Sign Up</MenuItem>
                            </Link>
                        </>
                        )

                    </div>
                </Toolbar>
            </AppBar>
        </div>
    );
};

export default Header;

const useStyles = makeStyles((theme) => ({

    root: {
        flexGrow: 1,
    },

    menuButton: {
        marginRight: theme.spacing(2),
    },

    title: {
        [theme.breakpoints.down('xs')]: {
            flexGrow: 1,
        },
    },

    headerOptions: {
        display: 'flex',
        flex: 1,
        justifyContent: 'flex-end',
    },
}));