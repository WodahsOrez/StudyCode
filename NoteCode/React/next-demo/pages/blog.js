
function Blog({ posts }) {
  return (
    <>
      实打实大所
    </>
  )
}

// 此函数在构建时被调用
export async function getStaticProps() {
  // 调用外部 API 获取博文列表
  // const res = await fetch('api/hello')
  // const posts = await res.json()
  const posts = [{title:'aaaaa'},{title:'bbbbb'}];

  // 通过返回 { props: posts } 对象，Blog 模块
  // 在构建时将接收到 `posts` 参数
  return {
    props: {
      posts,
    },
  }
}

export default Blog;