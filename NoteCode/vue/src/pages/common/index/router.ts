import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';

Vue.use(Router);

const router = new Router({
    routes: [
                {
            path: '/index/:index?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'index';
                const params: any = {};
                if (to.params && to.params[routerParamsName]) {
                    Object.assign(params, qs.parse(to.params[routerParamsName], { delimiter: ';' }));
                }
                const url: string = 'v7/appdata';
                const auth: Promise<any> = AuthGuard.getInstance().authGuard(url, params, router);
                auth.then(() => {
                    next();
                }).catch(() => {
                    next();
                });
            },
            meta: {  
                caption: '首页',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'index', parameterName: 'index' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/common/index/index.vue'),
            children: [
                {
                    path: 'entitytest1/:entitytest1id?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entitytest1.views.pickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'entitytest1', parameterName: 'entitytest1id' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/desktop/entitytest1-pickup-view/entitytest1-pickup-view.vue'),
                },
                {
                    path: 'entitytest1/:entitytest1id?/editview/:editview?',
                    meta: {
                        caption: 'entitytest1.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'entitytest1', parameterName: 'entitytest1id' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/desktop/entitytest1-edit-view/entitytest1-edit-view.vue'),
                },
                {
                    path: 'product/:productid?/editview9/:editview9?',
                    meta: {
                        caption: 'product.views.editview9.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'product', parameterName: 'productid' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/desktop/productedit-view9/productedit-view9.vue'),
                },
                {
                    path: 'entitytest1/:entitytest1id?/usr2gridview/:usr2gridview?',
                    meta: {
                        caption: 'entitytest1.views.usr2gridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'entitytest1', parameterName: 'entitytest1id' },
                            { pathName: 'usr2gridview', parameterName: 'usr2gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/desktop/entitytest1-usr2-grid-view/entitytest1-usr2-grid-view.vue'),
                },
                {
                    path: 'entitytest1/:entitytest1id?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entitytest1.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'entitytest1', parameterName: 'entitytest1id' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/desktop/entitytest1-pickup-grid-view/entitytest1-pickup-grid-view.vue'),
                },
                {
                    path: 'entitytest1/:entitytest1id?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entitytest1.views.mpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'entitytest1', parameterName: 'entitytest1id' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/desktop/entitytest1-mpickup-view/entitytest1-mpickup-view.vue'),
                },
                {
                    path: 'product/:productid?/editview/:editview?',
                    meta: {
                        caption: 'product.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'product', parameterName: 'productid' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/desktop/productedit-view/productedit-view.vue'),
                },
            ],
        },
        {
            path: '/login/:login?',
            name: 'login',
            meta: {  
                caption: '登录',
                viewType: 'login',
                requireAuth: false,
                ignoreAddPage: true,
            },
            beforeEnter: (to: any, from: any, next: any) => {
                router.app.$store.commit('resetRootStateData');
                next();
            },
            component: () => import('@components/login/login.vue'),
        },
        {
            path: '/404',
            component: () => import('@components/404/404.vue')
        },
        {
            path: '/500',
            component: () => import('@components/500/500.vue')
        },
        {
            path: '*',
            redirect: 'index'
        },
    ],
});

export default router;
