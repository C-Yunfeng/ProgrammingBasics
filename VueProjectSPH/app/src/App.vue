<template>
  <div id="app">
    <Header></Header>
    <router-view></router-view>
    <Footer
        v-if="$route.path=='/Home'||$route.path=='/SearchSearch'"
    ></Footer>
  </div>
</template>

<script>
import Header from '@/components/Header'
import Footer from '@/components/Footer'

export default {
  name: 'App',
  components: {
    Header,
    Footer,
  }
}
</script>


