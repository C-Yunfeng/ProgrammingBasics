module.exports = {
  presets: [
    '@vue/cli-plugin-babel/preset',
      ["@babel/present-env",{"modules":false}],
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
