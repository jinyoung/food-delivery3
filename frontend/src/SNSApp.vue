

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>

            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="menus"
                        to="/fronts/menus"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        메뉴
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="orders"
                        to="/fronts/orders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        주문
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="riders"
                        to="/fronts/riders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        라이더
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="deliveries"
                        to="/fronts/deliveries"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        배달
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="notifications"
                        to="/fronts/notifications"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        알림
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="transactions"
                        to="/fronts/transactions"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        거래
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="stores"
                        to="/stores/stores"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        상점
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="owners"
                        to="/stores/owners"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        사장님
                    </v-list-item>


                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; margin:0px 0px 20px 0px; position: relative;">
                    <v-img style="width:100%; height:300px;"
                        src=""
                    ></v-img>
                    <div class="App-main-text-overlap"></div>
                    <div class="App-sub-text-overlap"></div>
                </div>
                <v-row>
                    <v-col cols="4" class="d-flex justify-center" v-for="(aggregate, index) in aggregates" :key="index">
                        <div 
                            class="flip-card"
                            @mouseover="flipCard(index)"
                            @mouseleave="unflipCard(index)"
                            :class="{ 'is-flipped': flipped[index] }"
                        >
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <v-card
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="ImageUrl"></v-img>
                                        </v-list-item>
                                        <div style="text-align: left; padding:10px 15px 15px 15px; margin-top:-10px;">
                                            <h2>{{ aggregate.title }}</h2>
                                            <div>{{ aggregate.description }}</div>
                                        </div>
                                    </v-card>
                                </div>
                                <div class="flip-card-back">
                                    <v-card
                                        color="primary"
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                        :key="aggregate.key"
                                        :to="aggregate.route"
                                        @click="changeUrl()"
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="height:120px; border-radius: 10px;" :src="ImageUrl"></v-img>
                                        </v-list-item>
                                        <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                                    </v-card>
                                </div>
                            </div>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: ''
        aggregates: [
            { 
                title: '메뉴', 
                description: '식당의 메뉴 정보', 
                key: 'menus', 
                route: '/fronts/menus',
            },
            { 
                title: '주문', 
                description: '프론트에서 주문에 대한 정보', 
                key: 'orders', 
                route: '/fronts/orders',
            },
            { 
                title: '라이더', 
                description: '라이더의 정보', 
                key: 'riders', 
                route: '/fronts/riders',
            },
            { 
                title: '배달', 
                description: '주문의 배달 정보', 
                key: 'deliveries', 
                route: '/fronts/deliveries',
            },
            { 
                title: '알림', 
                description: '알림 정보', 
                key: 'notifications', 
                route: '/fronts/notifications',
            },
            { 
                title: '거래', 
                description: '주문 거래 정보', 
                key: 'transactions', 
                route: '/fronts/transactions',
            },
            { 
                title: '상점', 
                description: '상점 정보', 
                key: 'stores', 
                route: '/stores/stores',
            },
            { 
                title: '사장님', 
                description: '사장님 정보', 
                key: 'owners', 
                route: '/stores/owners',
            },
            
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
