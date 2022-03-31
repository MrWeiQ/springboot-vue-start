<template>
    <div>
        <el-row :gutter="10" style="margin-bottom: 50px">
            <el-col :span="6">
                <el-card style="color: #409EFF">
                    <div>用户总数</div>
                    <div style="padding: 10px 0; text-align: center; font-weight: bold">
                        100000
                    </div>
                </el-card>
            </el-col>
            <el-col :span="6">
                <el-card style="color: #67C23A">
                    <div>销售总量</div>
                    <div style="padding: 10px 0; text-align: center; font-weight: bold">
                        ￥ 100000000
                    </div>
                </el-card>
            </el-col>
            <el-col :span="6">
                <el-card  style="color: #67C23A">
                    <div>收益总额</div>
                    <div style="padding: 10px 0; text-align: center; font-weight: bold">
                        ￥ 30000000
                    </div>
                </el-card>
            </el-col>
            <el-col :span="6">
                <el-card  style="color: #dc83e6">
                    <div>门店总数</div>
                    <div style="padding: 10px 0; text-align: center; font-weight: bold">
                        200
                    </div>
                </el-card>
            </el-col>
        </el-row>

        <el-row>
            <el-col :span="12">
                <div id="main" style="width: 500px; height: 400px"></div>
            </el-col>
            <el-col :span="12">
                <div id="pie" style="width: 500px; height: 400px"></div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import * as echarts from 'echarts'
export default {
    name: "Home",
    data(){
        return{
        }
    },
    mounted() { //页面元素渲染之后再触发
        var chartDom = document.getElementById('main');
        var myChart = echarts.init(chartDom);
        var option = {
            title: {
                text: '各季度会员数量统计',
                subtext: '折线图',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            xAxis: {
                type: 'category',
                data: []
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: "瑞星咖啡",
                    data: [],
                    type: 'line'
                },
                {
                    name: "瑞星咖啡",
                    data: [],
                    type: 'bar'
                },
                {
                    name: "星巴克",
                    data: [],
                    type: 'bar'
                },
                {
                    name: "星巴克",
                    data: [],
                    type: 'line'
                },
            ]
        };

        this.request.get("/echarts/example").then(res => {
            option.xAxis.data = res.data.x;
            option.series[0].data = res.data.y;
            option.series[1].data = res.data.y;
            option.series[2].data = [50,100,150,200,250,300,350];
            option.series[3].data = [50,100,150,200,250,300,350];
            //在数据准备完毕之后在set
            myChart.setOption(option);
        });


        // 饼图
        var pieOption = {
            title: {
                text: '各季度会员数量统计',
                subtext: '比例图',
                left: 'center'
            },
            /*鼠标移到图上会显示文字*/
            tooltip: {
                trigger: 'item'
            },
            /*图旁边显示数字*/
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    type: 'pie',
                    radius: '60%',
                    label:{            //饼图图形上的文本标签
                        normal:{
                            show:true,
                            position:'inner', //标签的位置
                            textStyle : {
                                fontWeight : 300 ,
                                fontSize : 14,    //文字的字体大小
                                color: "#fff"
                            },
                            formatter:'{d}%'
                        }
                    },
                    data: [],  // 填空
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        var pieDom = document.getElementById('pie');
        var pieChart = echarts.init(pieDom);

        this.request.get("/echarts/members").then(res => {
            pieOption.series[0].data = [
                {name: "第一季度", value: res.data[0]},
                {name: "第二季度", value: res.data[1]},
                {name: "第三季度", value: res.data[2]},
                {name: "第四季度", value: res.data[3]},
            ]
            pieChart.setOption(pieOption)
        })
    }
}
</script>

<style scoped>

</style>