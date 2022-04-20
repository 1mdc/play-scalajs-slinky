module.exports = {
  "entry": {
    "client-fastopt": ["/Users/hoang.ong/projects/play-scalajs/client/target/scala-2.13/scalajs-bundler/main/client-fastopt.js"]
  },
  "output": {
    "path": "/Users/hoang.ong/projects/play-scalajs/client/target/scala-2.13/scalajs-bundler/main",
    "filename": "[name]-bundle.js"
  },
  "mode": "development",
  "devtool": "source-map",
  "module": {
    "rules": [
      {
        test: /\.s[ac]ss$/i,
        use: [
          "style-loader",
          "css-loader",
          "sass-loader",
        ],
      }, {
        test: /\.css$/i,
        use: ["style-loader", "css-loader"],
      }, {
        "test": new RegExp("\\.js$"),
        "enforce": "pre",
        "use": ["source-map-loader"]
      }
    ]
  }
}