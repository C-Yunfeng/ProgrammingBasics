module.exports = {
  presets: [
    '@vue/cli-plugin-babel/preset',
      // 默认的@bable/present-env会报错，改成preset-env就能跑了
      ["@babel/preset-env",{"modules":false}],
  ],
  plugins: [
    [
        "component",
      {
        "libraryName":"element-ui",
        "styleLibraryName":"theme-chalk"
      }
    ]
  ]
}
