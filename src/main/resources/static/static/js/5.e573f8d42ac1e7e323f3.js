webpackJsonp([5],{LB8P:function(e,t,i){var a={"./SetSetting.vue":"UuUC","./basic/Organizationed.vue":"LpkV","./resource.vue":"TnRj"};function l(e){return i(r(e))}function r(e){var t=a[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}l.keys=function(){return Object.keys(a)},l.resolve=r,e.exports=l,l.id="LB8P"},LpkV:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=i("bOdI"),l=i.n(a),r=i("mvHQ"),s=i.n(r),n={data:function(){return{treeInitData:JSON.parse(s()([{children:[],label:"项目",id:0,isLeaf:!1}])),depName:"",treeLoading:!1,dialogVisible:!1,orgDialogVisible:!1,orgVisible:!1,allDeps:[],pDep:"",treeData:[],defaultProps:{children:"children",label:"label",id:"id",isLeaf:"isLeaf",disabled:"disabled"},orgDataNode:{orgId:"",orgName:""},orgData:{faId:"",faName:"",name:"",address:"",principal:"",phone:"",code:""},orgData2:{id:"",faId:"",faName:"",name:"",address:"",principal:"",phone:"",code:""}}},mounted:function(){},methods:{filterNode:function(e,t){return!e||-1!==t.name.indexOf(e)},loadChild:function(e,t){var i=this;if(null==e.parent){var a=[];return a.push({children:[],label:"项目",id:null,isLeaf:!1,disabled:!0}),void t(a)}var l=e.data.id,r=t;this.postRequestJson("/busi/baseinfo/organization/list",{orgId:l,projectId:this.user.projectId}).then(function(e){if(i.tableLoading=!1,e&&200===e.status){i.treeLoading=!1;for(var t=[],a=0;a<e.data.msg.result.length;a++)t.push({id:e.data.msg.result[a].id,label:e.data.msg.result[a].name,children:[],isLeaf:e.data.msg.result[a].isLeaf,disabled:e.data.msg.result[a].isDisabled});r(t)}})},addDep:function(){var e=this,t=this;this.dialogVisible=!1,this.treeLoading=!0,this.postRequestJson("/busi/baseinfo/organization",{name:this.orgData.name,code:this.orgData.code,faId:this.pDep,address:this.orgData.address,principal:this.orgData.principal,phone:this.orgData.phone,projectId:this.user.projectId}).then(function(i){t.treeLoading=!1,i&&200===i.status&&(e.getMssage(i.data.msg),e.getRewOrgcod(e.pDep))})},UpdateDep:function(){var e=this;this.putRequestJson("/busi/baseinfo/organization",{name:this.orgData2.name,code:this.orgData2.code,id:this.pDep,address:this.orgData2.address,principal:this.orgData2.principal,phone:this.orgData2.phone,projectId:this.user.projectId}).then(function(t){t&&200===t.status&&(e.getMssage(t.data.msg),e.orgDialogVisible=!1)})},getMssage:function(e){var t=this;this.$confirm(e,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.dialogVisible=!1}).catch(function(){})},showAddDepView:function(e,t){this.dialogVisible=!0,this.pDep=e.id,this.orgData.faName=e.label,t.stopPropagation()},showUpdateDep:function(e,t){var i=this;this.orgDialogVisible=!0,this.pDep=e.id,this.orgData2.faName=e.label,this.getRequest("/busi/baseinfo/organization?id="+e.id).then(function(e){e&&200===e.status&&((e.data.code=200)?(i.orgData2.code=e.data.msg.code,i.orgData2.name=e.data.msg.name,i.orgData2.phone=e.data.msg.phone,i.orgData2.principal=e.data.msg.principal,i.orgData2.address=e.data.msg.address):i.getMssage(e.data.msg))}),t.stopPropagation()},orgVisibleDep:function(e,t){var i=this;this.orgVisible=!0,this.pDep=e.id,this.orgData2.faName=e.label,this.getRequest("/busi/baseinfo/organization?id="+e.id).then(function(e){e&&200===e.status&&((e.data.code=200)?(i.orgData2.code=e.data.msg.code,i.orgData2.name=e.data.msg.name,i.orgData2.phone=e.data.msg.phone,i.orgData2.principal=e.data.msg.principal,i.orgData2.address=e.data.msg.address):i.getMssage(e.data.msg))}),t.stopPropagation()},deleteDep:function(e,t,i,a){var l=this,r=this,s=i.parent.key;e.children.length>0?this.$message({message:"该科室下尚有其他部门，不能被停用!",type:"warning"}):this.$confirm("停用["+e.label+"]科室, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){r.treeLoading=!0,r.deleteRequest("/busi/baseinfo/organization?id="+e.id+"&status="+a).then(function(e){r.treeLoading=!1,e&&200===e.status&&l.getMssage(e.data.msg),l.getRewOrgcod(s)})}).catch(function(){r.$message({type:"info",message:"已取消删除"})}),t.stopPropagation()},getRewOrgcod:function(e){var t=this;this.postRequestJson("/busi/baseinfo/organization/list",{orgId:e,projectId:this.user.projectId}).then(function(i){if(t.tableLoading=!1,i&&200===i.status){t.treeLoading=!1;for(var a=[],l=0;l<i.data.msg.result.length;l++)a.push({id:i.data.msg.result[l].id,label:i.data.msg.result[l].name,children:[],isLeaf:i.data.msg.result[l].isLeaf,disabled:i.data.msg.result[l].isDisabled});t.$refs.tree.updateKeyChildren(e,a)}})},renderContent:function(e,t){var i,a,r,s,n,o,c,p,d,u,m=this,f=t.node,g=t.data,y=(t.store,e("span",{style:"flex: 1; display: flex; align-items: center; justify-content: space-between; font-size: 14px; padding-right: 8px;"},[e("span",[e("span",[f.label])]),e("span",[e("el-button",(i={style:"font-size: 12px;",attrs:{type:"primary",icon:"el-icon-plus",round:!0,size:"mini"}},l()(i,"style","padding:3px"),l()(i,"on",{click:function(){return m.showAddDepView(g,event)}}),i)),e("el-button",(a={style:"font-size: 12px;",attrs:{type:"primary",round:!0,icon:"el-icon-edit",size:"mini"}},l()(a,"style","padding:3px"),l()(a,"on",{click:function(){return m.showUpdateDep(g,event)}}),a)),e("el-button",(r={style:"font-size: 12px;",attrs:{type:"primary",round:!0,icon:"el-icon-info",size:"mini"}},l()(r,"style","padding:3px"),l()(r,"on",{click:function(){return m.orgVisibleDep(g,event)}}),r)),e("el-button",l()({style:"font-size: 12px;",attrs:{type:"primary",round:!0,size:"mini"}},"style","padding:3px"),["启用科室"]),e("el-button",l()({on:{click:function(){return m.deleteDep(g,event,f,!1)}},style:"font-size: 12px;",attrs:{type:"danger",round:!0,size:"mini"}},"style","padding:3px"),["停用科室"])])]),e("span",{style:"flex: 1; display: flex; align-items: center; justify-content: space-between; font-size: 14px; padding-right: 8px;"},[e("span",[e("span",[f.label])]),e("span",[e("el-button",(s={style:"font-size: 12px;",attrs:{type:"primary",icon:"el-icon-plus",round:!0,size:"mini"}},l()(s,"style","padding:3px"),l()(s,"on",{click:function(){return m.showAddDepView(g,event)}}),s)),e("el-button",(n={style:"font-size: 12px;",attrs:{type:"primary",round:!0,icon:"el-icon-edit",size:"mini"}},l()(n,"style","padding:3px"),l()(n,"on",{click:function(){return m.showUpdateDep(g,event)}}),n)),e("el-button",(o={style:"font-size: 12px;",attrs:{type:"primary",round:!0,icon:"el-icon-info",size:"mini"}},l()(o,"style","padding:3px"),l()(o,"on",{click:function(){return m.orgVisibleDep(g,event)}}),o))])])),b=e("span",{style:"flex: 1; display: flex; align-items: center; justify-content: space-between; font-size: 14px; padding-right: 8px;"},[e("span",[e("span",[f.label])]),e("span",[e("el-button",(c={style:"font-size: 12px;",attrs:{type:"primary",icon:"el-icon-plus",round:!0,size:"mini"}},l()(c,"style","padding:3px"),l()(c,"on",{click:function(){return m.showAddDepView(g,event)}}),c)),e("el-button",(p={style:"font-size: 12px;",attrs:{type:"primary",round:!0,icon:"el-icon-edit",size:"mini"}},l()(p,"style","padding:3px"),l()(p,"on",{click:function(){return m.showUpdateDep(g,event)}}),p)),e("el-button",(d={style:"font-size: 12px;",attrs:{type:"primary",round:!0,icon:"el-icon-info",size:"mini"}},l()(d,"style","padding:3px"),l()(d,"on",{click:function(){return m.orgVisibleDep(g,event)}}),d)),e("el-button",l()({on:{click:function(){return m.deleteDep(g,event,f,!0)}},style:"font-size: 12px;",attrs:{type:"danger",round:!0,size:"mini"}},"style","padding:3px"),["停用科室"])])]),v=e("span",{style:"flex: 1; display: flex; align-items: center; justify-content: space-between; font-size: 14px; padding-right: 8px;"},[e("span",[e("span",[f.label])]),e("span",[e("el-button",(u={style:"font-size: 12px;",attrs:{type:"primary",round:!0,size:"mini"}},l()(u,"style","padding:3px"),l()(u,"on",{click:function(){return m.deleteDep(g,event,f,!1)}}),u),["启用科室"])])]);return f.isLeaf?f.disabled?v:b:y}},computed:{user:function(){return this.$store.state.user}}},o={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("div",[i("el-tree",{directives:[{name:"loading",rawName:"v-loading",value:e.treeLoading,expression:"treeLoading"}],ref:"tree",staticStyle:{width:"500px","margin-top":"10px"},attrs:{props:e.defaultProps,load:e.loadChild,"node-key":"id",lazy:"","filter-node-method":e.filterNode,"render-content":e.renderContent}}),e._v(" "),i("div",{staticStyle:{"text-align":"left"}},[i("el-dialog",{attrs:{title:"添加科室",visible:e.dialogVisible,width:"50%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[i("el-form",[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室编号:"}},[i("el-input",{staticStyle:{width:"130px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入类型名称"},model:{value:e.orgData.code,callback:function(t){e.$set(e.orgData,"code",t)},expression:"orgData.code"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室名称:"}},[i("el-input",{staticStyle:{width:"130px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入科室名称"},model:{value:e.orgData.name,callback:function(t){e.$set(e.orgData,"name",t)},expression:"orgData.name"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室负责人:"}},[i("el-input",{staticStyle:{width:"118px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入科室负责人"},model:{value:e.orgData.principal,callback:function(t){e.$set(e.orgData,"principal",t)},expression:"orgData.principal"}})],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"上级单位:"}},[i("el-input",{staticStyle:{width:"130px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",disabled:"disabled"},model:{value:e.orgData.faName,callback:function(t){e.$set(e.orgData,"faName",t)},expression:"orgData.faName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"联系方式:"}},[i("el-input",{staticStyle:{width:"130px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入联系方式"},model:{value:e.orgData.phone,callback:function(t){e.$set(e.orgData,"phone",t)},expression:"orgData.phone"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室地址:"}},[i("el-input",{staticStyle:{width:"130px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入科室地址"},model:{value:e.orgData.address,callback:function(t){e.$set(e.orgData,"address",t)},expression:"orgData.address"}})],1)],1)],1)],1),e._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取消")]),e._v(" "),i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.addDep}},[e._v("添加")])],1)],1),e._v(" "),i("el-dialog",{attrs:{title:"编辑科室",visible:e.orgDialogVisible,width:"50%"},on:{"update:visible":function(t){e.orgDialogVisible=t}}},[i("el-form",[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室编号:"}},[i("el-input",{staticStyle:{width:"130px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入类型名称"},model:{value:e.orgData2.code,callback:function(t){e.$set(e.orgData2,"code",t)},expression:"orgData2.code"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室名称:"}},[i("el-input",{staticStyle:{width:"130px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入科室名称"},model:{value:e.orgData2.name,callback:function(t){e.$set(e.orgData2,"name",t)},expression:"orgData2.name"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室负责人:"}},[i("el-input",{staticStyle:{width:"118px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入科室负责人"},model:{value:e.orgData2.principal,callback:function(t){e.$set(e.orgData2,"principal",t)},expression:"orgData2.principal"}})],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"联系方式:"}},[i("el-input",{staticStyle:{width:"130px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入联系方式"},model:{value:e.orgData2.phone,callback:function(t){e.$set(e.orgData2,"phone",t)},expression:"orgData2.phone"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室地址:"}},[i("el-input",{staticStyle:{width:"130px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入科室地址"},model:{value:e.orgData2.address,callback:function(t){e.$set(e.orgData2,"address",t)},expression:"orgData2.address"}})],1)],1)],1)],1),e._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"small"},on:{click:function(t){e.orgDialogVisible=!1}}},[e._v("取消")]),e._v(" "),i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.UpdateDep}},[e._v("修改")])],1)],1),e._v(" "),i("el-dialog",{attrs:{title:"科室信息",visible:e.orgVisible,width:"50%"},on:{"update:visible":function(t){e.orgVisible=t}}},[i("el-form",[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室编号:"}},[e._v("\n                "+e._s(e.orgData2.code)+"\n              ")])],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室名称:"}},[e._v("\n                "+e._s(e.orgData2.name)+"\n              ")])],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室负责人:"}},[e._v("\n                "+e._s(e.orgData2.principal)+"\n              ")])],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"联系方式:"}},[e._v("\n                "+e._s(e.orgData2.phone)+"\n              ")])],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"科室地址:"}},[e._v("\n                "+e._s(e.orgData2.address)+"\n              ")])],1)],1)],1),e._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"small"},on:{click:function(t){e.orgVisible=!1}}},[e._v("关闭")])],1)],1)],1)],1)])},staticRenderFns:[]},c=i("VU/8")(n,o,!1,null,null,null);t.default=c.exports},TnRj:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticStyle:{"margin-top":"20px"}},[i("el-form",[i("el-row",[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.resourceList,border:"",size:"mini"}},[i("el-table-column",{attrs:{prop:"faid",align:"center",label:"父记录号"}}),e._v(" "),e._e(),e._v(" "),i("el-table-column",{attrs:{prop:"name",align:"center",label:"资源名"}}),e._v(" "),i("el-table-column",{attrs:{prop:"url",align:"center",label:"URL"}}),e._v(" "),i("el-table-column",{attrs:{prop:"type",align:"center",label:"类型"}}),e._v(" "),i("el-table-column",{attrs:{prop:"componet",align:"center",label:"资源名称"}}),e._v(" "),i("el-table-column",{attrs:{prop:"icon",align:"center",label:"图标"}}),e._v(" "),i("el-table-column",{attrs:{prop:"scope",align:"center",label:"范围"}}),e._v(" "),i("el-table-column",{attrs:{prop:"requesmethod",align:"center",label:"资源请求方法"}}),e._v(" "),i("el-table-column",{attrs:{prop:"iSDisabled",align:"center",label:"是否不可用"}}),e._v(" "),i("el-table-column",{attrs:{prop:"isRequireAuth",align:"center",label:"是否需要权限"}}),e._v(" "),i("el-table-column",{attrs:{prop:"version",align:"center",label:"版本"}}),e._v(" "),i("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{staticStyle:{padding:"3px 10px 3px 10px",margin:"2px"},attrs:{size:"small"},on:{click:function(i){e.showEditEmpView(t.row)}}},[e._v("编辑\n            ")])]}}])})],1)],1)],1),e._v(" "),i("el-form",{staticStyle:{margin:"0px",padding:"0px"}},[i("div",{staticStyle:{"text-align":"left"}},[i("el-dialog",{staticStyle:{padding:"0px"},attrs:{title:e.dialogTitle,"close-on-click-modal":!1,visible:e.resourceVisible,width:"65%"},on:{"update:visible":function(t){e.resourceVisible=t}}},[i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"资源名:"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入资源名"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"URL:",prop:"startCode"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入URL"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"类型:",prop:"endCode"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入类型"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"资源名称:",prop:"endCode"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入资源名称"}})],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"图 标:"}},[i("el-input",{staticStyle:{width:"155px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入图标"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"资源操作域:",prop:"startCode"}},[i("el-input",{staticStyle:{width:"110px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入资源操作域"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"资源请求方法:",prop:"endCode"}},[i("el-input",{staticStyle:{width:"95px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入资源请求方法"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"是否不可用:",prop:"endCode"}},[i("el-select",{staticStyle:{width:"135px"},attrs:{size:"mini",placeholder:"是否需要权限"},model:{value:e.disabledid,callback:function(t){e.disabledid=t},expression:"disabledid"}},e._l(e.disabledData,function(e){return i("el-option",{key:e.disabledid,attrs:{label:e.mame,value:e.disabledid}})}))],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"是否需要权限:"}},[i("el-select",{staticStyle:{width:"100px"},attrs:{size:"mini",placeholder:"是否需要权限"},model:{value:e.requireid,callback:function(t){e.requireid=t},expression:"requireid"}},e._l(e.requireData,function(e){return i("el-option",{key:e.requireid,attrs:{label:e.mame,value:e.requireid}})}))],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"版本:"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入版本"}})],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:13}},[i("el-form-item",{staticStyle:{float:"right"}},[i("el-button",{attrs:{size:"mini",icon:"el-icon-edit",type:"primary"},on:{click:e.madyifResource}},[e._v("修改资源")])],1)],1)],1)],1)],1)])],1)},staticRenderFns:[]};var l=i("VU/8")({data:function(){return{resourceList:[],tableLoading:!1,dialogTitle:"",resourceVisible:!1,disabledid:"1",requireid:"1",requireData:[{requireid:"1",mame:"是"},{requireid:"0",mame:"否"}],disabledData:[{disabledid:"1",mame:"是"},{disabledid:"0",mame:"否"}]}},mounted:function(){this.resourceVisible=!0},methods:{showEditEmpView:function(e){this.resourceVisible=!0},madyifResource:function(){this.dialogTitle="编辑资源信息",this.resourceVisible=!1}}},a,!1,function(e){i("uy+U")},"data-v-bfec6b40",null);t.default=l.exports},UuUC:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={data:function(){return{ServiceName:"",property:"",dialogTitle:"",docfileVisible:!1,tableLoading:!1,ServicedialogVisible:!1,MaydifydialogVisible:!1,ServiceList:[],docfileList:[],totalCount:-1,totalTaiCount:-1,currentPage:1,Servicetype:{name:"",property:"",price:"",salaryIndex:"",settleType:""},Servicetype2:{name:"",property:"",price:"",salaryIndex:"",settleType:""},serviceId:"",docfile:{CodeName:"",startCode:"",endCode:"",currentCode:""},docfile2:{name:"",startCode:"",currentCode:"",endCode:"",id:""},propertyData:[{property:"1",mame:"一对一"},{property:"2",mame:"一对多"},{property:"3",mame:"多对多"}],settleTypeData:[{settleType:"1",mame:"日"},{settleType:"2",mame:"例"}],rules:{name:[{required:!0,message:"必填:陪护类型名称",trigger:"blur"}],price:[{required:!0,message:"必填:单价",trigger:"blur"}],salaryIndex:[{required:!0,message:"必填:工资系数",trigger:"blur"}],CodeName:[{required:!0,message:"必填:单据名称",trigger:"blur"}],startCode:[{required:!0,message:"必填:起始单据号",trigger:"blur"}],endCode:[{required:!0,message:"必填:结束单据号",trigger:"blur"}]}}},mounted:function(){this.onServiceClick(),this.getdocfileList()},methods:{number:function(){this.Servicetype.salaryIndex=this.Servicetype.salaryIndex.replace(/[^\.\d]/g,""),this.Servicetype2.salaryIndex=this.Servicetype.salaryIndex.replace(/[^\.\d]/g,""),this.Servicetype.price=this.Servicetype.price.replace(/[^\.\d]/g,""),this.Servicetype2.price=this.Servicetype.price.replace(/[^\.\d]/g,"")},onServiceClick:function(){var e=this;this.tableLoading=!0,this.postRequestJson("/busi/baseinfo/caretype/list",{name:this.ServiceName,property:this.property,curPage:this.currentPage,projectId:this.user.projectId}).then(function(t){e.tableLoading=!1,t&&200===t.status?"200"===t.data.code?(e.ServiceList=t.data.msg.result,e.totalTaiCount=t.data.msg.totalSize):e.getMssage(t.data.msg):e.getMssage(t.status)})},ServiceChange:function(e){this.currentPage=e,this.getdocfileList()},ServiceTiaChange:function(e){this.currentPage=e,this.onServiceClick()},showAddEmpView:function(){this.dialogTitle="添加陪护类型",this.ServicedialogVisible=!0,this.Servicetype.price="",this.Servicetype.salaryIndex="",this.Servicetype.settleType="",this.Servicetype.name="",this.Servicetype.property=""},addServiceOnclick:function(){var e=this;this.postRequestJson("/busi/baseinfo/caretype",{name:this.Servicetype.name,property:this.Servicetype.property,price:this.Servicetype.price,salaryIndex:this.Servicetype.salaryIndex,settleType:this.Servicetype.settleType,projectId:this.user.projectId}).then(function(t){e.tableLoading=!1,t&&200===t.status?e.getMssage(t.data.msg):e.getMssage(t.status)})},MadfiyServiceOnclick:function(){var e=this;this.putRequestJson("/busi/baseinfo/caretype",{id:this.serviceId,name:this.Servicetype2.name,property:this.Servicetype2.property,price:this.Servicetype2.price,salaryIndex:this.Servicetype2.salaryIndex,settleType:this.Servicetype2.settleType,projectId:this.user.projectId}).then(function(t){e.tableLoading=!1,t&&200===t.status?e.getMssage(t.data.msg):e.getMssage(t.status)})},showEditEmpView:function(e){this.dialogTitle="编辑陪护类型",this.MaydifydialogVisible=!0,this.Servicetype2.price=e.price,this.Servicetype2.name=e.name,this.serviceId=e.id,this.Servicetype2.salaryIndex=e.salaryIndex},cancelEidt:function(){this.ServicedialogVisible=!1,this.MaydifydialogVisible=!1},getMssage:function(e){var t=this;this.$confirm(e,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.ServicedialogVisible=!1,t.MaydifydialogVisible=!1,t.docfileVisible=!1,t.onServiceClick(),t.getdocfileList()}).catch(function(){})},getdocfileList:function(){var e=this;this.tableLoading=!0,this.postRequestJson("/busi/baseinfo/docfile/list",{name:"",curPage:this.currentPage}).then(function(t){e.tableLoading=!1,t&&200===t.status?"200"===t.data.code?(e.docfileList=t.data.msg.result,e.totalCount=t.data.msg.totalSize):e.getMssage(t.data.msg):e.getMssage(t.status)})},onDocfileClick:function(){var e=this;this.postRequestJson("/busi/baseinfo/docfile",{name:this.docfile.CodeName,startCode:this.docfile.startCode,endCode:this.docfile.endCode,projectId:this.user.projectId}).then(function(t){t&&t.status,e.getMssage(t.data.msg)})},showDocfileView:function(e){this.dialogTitle="编辑单据编号",this.docfileVisible=!0,this.docfile2.id=e.id,this.docfile2.name=e.name,this.docfile2.startCode=e.startCode,this.docfile2.endCode=e.endCode},madyifdocfile:function(){var e=this;this.putRequestJson("/busi/baseinfo/docfile",{name:this.docfile2.name,startCode:this.docfile2.startCode,currentCode:this.docfile2.startCode,endCode:this.docfile2.endCode,id:this.docfile2.id,projectId:this.user.projectId}).then(function(t){t&&t.status,e.getMssage(t.data.msg)})}},components:{"menu-org":i("LpkV").default},computed:{user:function(){return this.$store.state.user}}},l={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticStyle:{"margin-top":"15px"}},[i("el-tabs",{attrs:{type:"card"}},[i("el-tab-pane",{attrs:{label:"科室管理",name:"Organization"}},[i("menu-org")],1),e._v(" "),i("el-tab-pane",{attrs:{label:"陪护类型设置"}},[i("el-form",[i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"陪护类型名称"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入陪护类型名称"},model:{value:e.ServiceName,callback:function(t){e.ServiceName=t},expression:"ServiceName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"陪护属性:"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"请选择陪护属性"},model:{value:e.property,callback:function(t){e.property=t},expression:"property"}},e._l(e.propertyData,function(e){return i("el-option",{key:e.property,attrs:{label:e.mame,value:e.property}})}))],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{staticStyle:{float:"left"}},[i("el-button",{attrs:{size:"mini",icon:"el-icon-search",type:"primary"},on:{click:e.onServiceClick}},[e._v("查 询")])],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{staticStyle:{float:"right"}},[i("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-plus"},on:{click:e.showAddEmpView}},[e._v("添加陪护类型 ")])],1)],1)],1),e._v(" "),i("el-row",[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.ServiceList,border:"",size:"mini"}},[i("el-table-column",{attrs:{prop:"name",align:"center",label:"陪护类型名称"}}),e._v(" "),e._e(),e._v(" "),i("el-table-column",{attrs:{prop:"price",align:"center",label:"单价"}}),e._v(" "),i("el-table-column",{attrs:{prop:"propertyName",align:"center",label:"陪护属性"}}),e._v(" "),i("el-table-column",{attrs:{prop:"salaryIndex",align:"center",label:"工资系数(%)"}}),e._v(" "),i("el-table-column",{attrs:{prop:"settleTypeName",align:"center",label:"计算方式"}}),e._v(" "),i("el-table-column",{attrs:{align:"center",label:"操作",width:"150"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{staticStyle:{padding:"3px 10px 3px 10px",margin:"2px"},attrs:{size:"small"},on:{click:function(i){e.showEditEmpView(t.row)}}},[e._v("编辑\n                      ")])]}}])})],1),e._v(" "),i("div",{staticStyle:{display:"flex","justify-content":"space-between",margin:"2px",float:"right"}},[i("el-pagination",{attrs:{background:"","page-size":10,"current-page":e.currentPage,layout:"prev, pager, next",total:e.totalTaiCount},on:{"current-change":e.ServiceTiaChange}})],1)],1)],1),e._v(" "),i("el-form",{staticStyle:{margin:"0px",padding:"0px"},attrs:{model:e.Servicetype,rules:e.rules}},[i("div",{staticStyle:{"text-align":"left"}},[i("el-dialog",{staticStyle:{padding:"0px"},attrs:{title:e.dialogTitle,"close-on-click-modal":!1,visible:e.ServicedialogVisible,width:"65%"},on:{"update:visible":function(t){e.ServicedialogVisible=t}}},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"陪护类型名称:",prop:"name"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入类型名称"},model:{value:e.Servicetype.name,callback:function(t){e.$set(e.Servicetype,"name",t)},expression:"Servicetype.name"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"陪护属性:"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"请选择陪护属性"},model:{value:e.Servicetype.property,callback:function(t){e.$set(e.Servicetype,"property",t)},expression:"Servicetype.property"}},e._l(e.propertyData,function(e){return i("el-option",{key:e.property,attrs:{label:e.mame,value:e.property}})}))],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"单 价:",prop:"price"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入单价"},nativeOn:{keyup:function(t){return e.number(t)}},model:{value:e.Servicetype.price,callback:function(t){e.$set(e.Servicetype,"price",t)},expression:"Servicetype.price"}})],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"工资系数:",prop:"salaryIndex"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入工资系数"},nativeOn:{keyup:function(t){return e.number(t)}},model:{value:e.Servicetype.salaryIndex,callback:function(t){e.$set(e.Servicetype,"salaryIndex",t)},expression:"Servicetype.salaryIndex"}}),e._v("%\n                 ")],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"结算方式:",prop:"phone"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"请选择结算方式"},model:{value:e.Servicetype.settleType,callback:function(t){e.$set(e.Servicetype,"settleType",t)},expression:"Servicetype.settleType"}},e._l(e.settleTypeData,function(e){return i("el-option",{key:e.settleType,attrs:{label:e.mame,value:e.settleType}})}))],1)],1)],1),e._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"mini"},on:{click:e.cancelEidt}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{size:"mini",type:"primary"},on:{click:e.addServiceOnclick}},[e._v("确 定")])],1)],1)],1)]),e._v(" "),i("el-form",{staticStyle:{margin:"0px",padding:"0px"},attrs:{model:e.Servicetype2,rules:e.rules}},[i("div",{staticStyle:{"text-align":"left"}},[i("el-dialog",{staticStyle:{padding:"0px"},attrs:{title:e.dialogTitle,"close-on-click-modal":!1,visible:e.MaydifydialogVisible,width:"65%"},on:{"update:visible":function(t){e.MaydifydialogVisible=t}}},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"陪护类型名称:",prop:"name"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入类型名称"},model:{value:e.Servicetype2.name,callback:function(t){e.$set(e.Servicetype2,"name",t)},expression:"Servicetype2.name"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"陪护属性:"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"请选择陪护属性"},model:{value:e.Servicetype2.property,callback:function(t){e.$set(e.Servicetype2,"property",t)},expression:"Servicetype2.property"}},e._l(e.propertyData,function(e){return i("el-option",{key:e.property,attrs:{label:e.mame,value:e.property}})}))],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"单 价:",prop:"price"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入单价"},nativeOn:{keyup:function(t){return e.number(t)}},model:{value:e.Servicetype2.price,callback:function(t){e.$set(e.Servicetype2,"price",t)},expression:"Servicetype2.price"}})],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"工资系数:",prop:"salaryIndex"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入工资系数"},nativeOn:{keyup:function(t){return e.number(t)}},model:{value:e.Servicetype2.salaryIndex,callback:function(t){e.$set(e.Servicetype2,"salaryIndex",t)},expression:"Servicetype2.salaryIndex"}}),e._v("%\n                 ")],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"结算方式:",prop:"phone"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"请选择结算方式"},model:{value:e.Servicetype2.settleType,callback:function(t){e.$set(e.Servicetype2,"settleType",t)},expression:"Servicetype2.settleType"}},e._l(e.settleTypeData,function(e){return i("el-option",{key:e.settleType,attrs:{label:e.mame,value:e.settleType}})}))],1)],1)],1),e._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"mini"},on:{click:e.cancelEidt}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{size:"mini",type:"primary"},on:{click:e.MadfiyServiceOnclick}},[e._v("确 定")])],1)],1)],1)])],1),e._v(" "),i("el-tab-pane",{attrs:{label:"单据编号设置"}},[i("el-form",{attrs:{rules:e.rules},model:{value:e.docfile,callback:function(t){e.docfile=t},expression:"docfile"}},[i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"单据名称",prop:"CodeName"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入陪护类型名称"},model:{value:e.docfile.CodeName,callback:function(t){e.$set(e.docfile,"CodeName",t)},expression:"docfile.CodeName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"起始单据号",prop:"startCode"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入起始单据号"},model:{value:e.docfile.startCode,callback:function(t){e.$set(e.docfile,"startCode",t)},expression:"docfile.startCode"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"结束单据号",prop:"endCode"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入结束单据号"},model:{value:e.docfile.endCode,callback:function(t){e.$set(e.docfile,"endCode",t)},expression:"docfile.endCode"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",{staticStyle:{float:"left"}},[i("el-button",{attrs:{size:"mini",icon:"el-icon-plus",type:"primary"},on:{click:e.onDocfileClick}},[e._v("添加单据号")])],1),e._v(" "),i("el-form-item",{staticStyle:{float:"right"}},[i("el-button",{attrs:{size:"mini",icon:"el-icon-search",type:"primary"},on:{click:e.getdocfileList}},[e._v("查 询")])],1)],1)],1),e._v(" "),i("el-row",[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.docfileList,border:"",size:"mini"}},[i("el-table-column",{attrs:{prop:"name",align:"center",label:"单据名称"}}),e._v(" "),e._e(),e._v(" "),i("el-table-column",{attrs:{prop:"currentCode",align:"center",label:"当前单据编号"}}),e._v(" "),i("el-table-column",{attrs:{prop:"startCode",align:"center",label:"起始单据编号"}}),e._v(" "),i("el-table-column",{attrs:{prop:"endCode",align:"center",label:"结束单据编号"}}),e._v(" "),i("el-table-column",{attrs:{align:"center",label:"操作",width:"150"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{staticStyle:{padding:"3px 10px 3px 10px",margin:"2px"},attrs:{size:"small"},on:{click:function(i){e.showDocfileView(t.row)}}},[e._v("编辑\n                      ")])]}}])})],1),e._v(" "),i("div",{staticStyle:{display:"flex","justify-content":"space-between",margin:"2px",float:"right"}},[i("el-pagination",{attrs:{background:"","page-size":10,"current-page":e.currentPage,layout:"prev, pager, next",total:e.totalCount},on:{"current-change":e.ServiceChange}})],1)],1)],1),e._v(" "),i("el-form",{staticStyle:{margin:"0px",padding:"0px"},attrs:{model:e.docfile2}},[i("div",{staticStyle:{"text-align":"left"}},[i("el-dialog",{staticStyle:{padding:"0px"},attrs:{title:e.dialogTitle,"close-on-click-modal":!1,visible:e.docfileVisible,width:"65%"},on:{"update:visible":function(t){e.docfileVisible=t}}},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"单据名称"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入陪护类型名称"},model:{value:e.docfile2.name,callback:function(t){e.$set(e.docfile2,"name",t)},expression:"docfile2.name"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"起始单据号",prop:"startCode"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入起始单据号"},model:{value:e.docfile2.startCode,callback:function(t){e.$set(e.docfile2,"startCode",t)},expression:"docfile2.startCode"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"结束单据号",prop:"endCode"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入结束单据号"},model:{value:e.docfile2.endCode,callback:function(t){e.$set(e.docfile2,"endCode",t)},expression:"docfile2.endCode"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:14}},[i("el-form-item",{staticStyle:{float:"right"}},[i("el-button",{attrs:{size:"mini",icon:"el-icon-edit",type:"primary"},on:{click:e.madyifdocfile}},[e._v("修改单据号")])],1)],1)],1)],1)],1)])],1)],1)],1)},staticRenderFns:[]};var r=i("VU/8")(a,l,!1,function(e){i("lNcc")},"data-v-9412b4c6",null);t.default=r.exports},lNcc:function(e,t){},"uy+U":function(e,t){}});
//# sourceMappingURL=5.e573f8d42ac1e7e323f3.js.map