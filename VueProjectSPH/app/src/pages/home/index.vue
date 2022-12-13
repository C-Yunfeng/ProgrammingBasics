<template>
  <div>
    <!--三级联动组件-->
    <TypeNav></TypeNav>
    <ListContainer></ListContainer>
    <Recommend></Recommend>
    <Rank></Rank>
    <Like></Like>
    <Floor></Floor>
    <Brand></Brand>
  </div>
</template>

<script>
import ListContainer from "@/pages/home/ListContainer";
import Recommend from "@/pages/home/Recommend";
import Rank from "@/pages/home/Rank";
import Like from "@/pages/home/Like";
import Floor from "@/pages/home/Floor";
import Brand from "@/pages/home/Brand";

export default {
  name: "Home",
  components:{
    ListContainer,
    Recommend,
    Rank,
    Like,
    Floor,
    Brand
  }
}
</script>

<style scoped>

</style>