import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/NavigationLayout.vue'),
    children: [{ path: '', component: () => import('pages/IndexPage.vue') }],
  },
  {
    path: '/school',
    component: () => import('layouts/NavigationLayout.vue'),
    children: [{ path: '', component: () => import('pages/SchoolPage.vue') }],
  },
  {
    path: '/students',
    component: () => import('layouts/NavigationLayout.vue'),
    children: [{ path: '', component: () => import('pages/StudentPage.vue') }],
  },
  {
    path: '/teacher',
    component: () => import('layouts/NavigationLayout.vue'),
    children: [{ path: '', component: () => import('pages/TeacherPage.vue') }],
  },
  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
