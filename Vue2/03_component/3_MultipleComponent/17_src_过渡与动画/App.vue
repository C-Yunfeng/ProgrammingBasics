<template>
  <div>
    <TransitionAnimation></TransitionAnimation>
    <TransitionAnimation2></TransitionAnimation2>
  </div>
</template>

<script>
  import TransitionAnimation from "./components/TransitionAnimation";
  import TransitionAnimation2 from "./components/TransitionAnimation2";
  import 'animate.css'

  export default {
    name: "App",
    components:{TransitionAnimation,TransitionAnimation2},
  }
</script>

