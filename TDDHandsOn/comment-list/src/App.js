import { useState } from "react";
import CommentList from "./CommentList";

function App({ commentComposer }) {
  const [comments, setComments] = useState([]);

  return (
    <div>
      <Form commentComposer={commentComposer} />
      <CommentList comments={comments}/>
    </div>
  );

  function Form({ commentComposer }) {
    const [author, setAuthor] = useState("");
    const [content, setContent] = useState("");

    const handleSubmit = (e) => {
      e.preventDefault();
      const newComment = commentComposer({ author, content }); // form 외부에서 전달된 것
      setComments([...[...comments], newComment]); // form 외부에서 전달된 것
      setAuthor("");
      setContent("");
    };

    return <form onSubmit={handleSubmit}>
      <input
          name="author"
          value={author}
          type="text"
          onChange={(e) => setAuthor(e.currentTarget.value)}
          placeholder="작성자"
      />
      <input
          name="content"
          value={content}
          type="text"
          onChange={(e) => setContent(e.currentTarget.value)}
          placeholder="내용"
      />
      <button name="submit">입력</button>
    </form>;
  }

}

export default App;
