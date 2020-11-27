export default function SimpleTable() {
    const classes = useStyles();
  
    const [data, upDateData] = React.useState([]);
    const [firstLoad, setLoad] = React.useState(true);
    let isLoading = true;
  
    async function sampleFunc() {
      let response = await fetch("/api/employee");
      let body = await response.json();
      upDateData(body);
    }
  
    if (firstLoad) {
      sampleFunc();
      setLoad(false);
    }
  
    if (data.length > 0) isLoading = false;
  
    return (
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <GroupIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Employee Directory
        </Typography>
  
        {isLoading ? (
          <CircularProgress />
        ) : (
          <TableContainer
            style={{ width: "80%", margin: "0 10px" }}
            component={Paper}>
            <Table className={classes.table} aria-label="simple table">
              <TableHead>
                <TableRow>
                  <TableCell align="center">Name</TableCell>
                  <TableCell align="center">Department</TableCell>
                  <TableCell align="center">Gender</TableCell>
                  <TableCell align="center">Dob</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {data?.map(row => (
                  <TableRow key={row.name}>
                    <TableCell align="center">{row.name}</TableCell>
                    <TableCell align="center">{row.department}</TableCell>
                    <TableCell align="center">{row.gender}</TableCell>
                    <TableCell align="center">{row.dob}</TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
        )}
        <Link className={classes.link} to="/">
          <Typography align="left">
            &#x2190; Head back to save data
          </Typography>
        </Link>
      </div>
    );
  }