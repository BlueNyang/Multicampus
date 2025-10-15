import axios from "axios";
import { useEffect, useState } from "react";

export const AxiosSpring = () => {
  const [data, setData] = useState<string>("");
  const [loading, setLoading] = useState<boolean>(false);

  const loadData = async () => {
    setLoading(true);

    try {
      const response = await axios.get("http://localhost:8080/hello");

      console.log(response);
      setData(response.data);
    } catch (err) {
      console.error(err);
      setData("Error fetching data");
    }

    setLoading(false);
  };

  useEffect(() => {
    loadData();
  }, []);

  return (
    <div>
      <h3>서버로부터 받아온 값</h3>
      {loading ? <p>Loading...</p> : <p>{data}</p>}
    </div>
  );
};
