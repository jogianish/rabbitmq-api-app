import { useState } from "react";
import ServiceDetails from "./ServiceDetails";

const PostDetails = () => {
  const [id, setId] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");

  const saveCustomers = (e) => {
    e.preventDefault();
    const student = {
      id,
      firstName,
      lastName,
    };
    ServiceDetails.PostDetails(student)
      .then((res) => {
        console.log(res.data);
        alert("Added Successfully");
      })
      .catch((error) => {
        alert("something went wrong");
        console.log(error);
      });
  };

  return (
    <div>
      <br></br>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h2 className="card-header text-center">Add Student Details</h2>
            <div className="card-body">
              <form>
                <div className="form-group row">
                  <label htmlFor="id" className="col-sm-3 col-form-label">
                    ID:
                  </label>
                  <div className="col-sm-9">
                    <input
                      type="number"
                      id="id"
                      placeholder="Enter Student ID"
                      name="id"
                      className="form-control"
                      value={id}
                      onChange={(e) => setId(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row">
                  <label
                    htmlFor="firstName"
                    className="col-sm-3 col-form-label"
                  >
                    First Name:
                  </label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      id="firstName"
                      placeholder="Enter Student Firstname"
                      name="firstName"
                      className="form-control"
                      value={firstName}
                      onChange={(e) => setFirstName(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row">
                  <label htmlFor="lastName" className="col-sm-3 col-form-label">
                    Last Name:
                  </label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      id="lastName"
                      placeholder="Enter Student LastName"
                      name="lastName"
                      className="form-control"
                      value={lastName}
                      onChange={(e) => setLastName(e.target.value)}
                    />
                  </div>
                  <button
                    className="btn btn-success"
                    onClick={(e) => saveCustomers(e)}
                  >
                    Submit
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PostDetails;
