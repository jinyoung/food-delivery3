
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import FrontMenuManager from "./components/listers/FrontMenuCards"
import FrontMenuDetail from "./components/listers/FrontMenuDetail"
import FrontOrderManager from "./components/listers/FrontOrderCards"
import FrontOrderDetail from "./components/listers/FrontOrderDetail"
import FrontRiderManager from "./components/listers/FrontRiderCards"
import FrontRiderDetail from "./components/listers/FrontRiderDetail"
import FrontDeliveryManager from "./components/listers/FrontDeliveryCards"
import FrontDeliveryDetail from "./components/listers/FrontDeliveryDetail"
import FrontNotificationManager from "./components/listers/FrontNotificationCards"
import FrontNotificationDetail from "./components/listers/FrontNotificationDetail"
import FrontTransactionManager from "./components/listers/FrontTransactionCards"
import FrontTransactionDetail from "./components/listers/FrontTransactionDetail"

import StoreStoreManager from "./components/listers/StoreStoreCards"
import StoreStoreDetail from "./components/listers/StoreStoreDetail"
import StoreOwnerManager from "./components/listers/StoreOwnerCards"
import StoreOwnerDetail from "./components/listers/StoreOwnerDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/fronts/menus',
                name: 'FrontMenuManager',
                component: FrontMenuManager
            },
            {
                path: '/fronts/menus/:id',
                name: 'FrontMenuDetail',
                component: FrontMenuDetail
            },
            {
                path: '/fronts/orders',
                name: 'FrontOrderManager',
                component: FrontOrderManager
            },
            {
                path: '/fronts/orders/:id',
                name: 'FrontOrderDetail',
                component: FrontOrderDetail
            },
            {
                path: '/fronts/riders',
                name: 'FrontRiderManager',
                component: FrontRiderManager
            },
            {
                path: '/fronts/riders/:id',
                name: 'FrontRiderDetail',
                component: FrontRiderDetail
            },
            {
                path: '/fronts/deliveries',
                name: 'FrontDeliveryManager',
                component: FrontDeliveryManager
            },
            {
                path: '/fronts/deliveries/:id',
                name: 'FrontDeliveryDetail',
                component: FrontDeliveryDetail
            },
            {
                path: '/fronts/notifications',
                name: 'FrontNotificationManager',
                component: FrontNotificationManager
            },
            {
                path: '/fronts/notifications/:id',
                name: 'FrontNotificationDetail',
                component: FrontNotificationDetail
            },
            {
                path: '/fronts/transactions',
                name: 'FrontTransactionManager',
                component: FrontTransactionManager
            },
            {
                path: '/fronts/transactions/:id',
                name: 'FrontTransactionDetail',
                component: FrontTransactionDetail
            },

            {
                path: '/stores/stores',
                name: 'StoreStoreManager',
                component: StoreStoreManager
            },
            {
                path: '/stores/stores/:id',
                name: 'StoreStoreDetail',
                component: StoreStoreDetail
            },
            {
                path: '/stores/owners',
                name: 'StoreOwnerManager',
                component: StoreOwnerManager
            },
            {
                path: '/stores/owners/:id',
                name: 'StoreOwnerDetail',
                component: StoreOwnerDetail
            },



    ]
})
