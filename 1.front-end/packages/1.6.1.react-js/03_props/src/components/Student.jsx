import React from 'react';

const Student = ({ studentInfo }) => {
  return (
    <div className='student-info'>
      <h2>Student Information</h2>
      <p>Name: {studentInfo.name}</p>
      <p>Age: {studentInfo.age}</p>
      <p>Year: {studentInfo.year}</p>
      <p>Address: {studentInfo.address}</p>
    </div>
  );
};

export default Student;
