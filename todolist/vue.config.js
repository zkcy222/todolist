module.exports = {
  lintOnSave: false, //关闭语法检查
  devServer: {
    proxy: {
      '/todoList': {
        target: 'http://localhost:9000',
        pathRewrite: {
          "^/todoList": ""
        }, //重写请求
        ws: true, //用于支持websocket
        changeOrigin: true //
      },
    }
  }
}