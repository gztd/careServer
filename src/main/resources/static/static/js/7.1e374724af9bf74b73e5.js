webpackJsonp([7],{GzbA:function(e,t){},OgOj:function(e,t,a){var i={"./Arrangement.vue":"fQWI"};function s(e){return a(r(e))}function r(e){var t=i[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}s.keys=function(){return Object.keys(i)},s.resolve=r,e.exports=s,s.id="OgOj"},fQWI:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i=a("bOdI"),s=a.n(i),r={data:function(){var e;return e={missionList:[],carreName:"",patientName:"",hideRow:!1,tableLoading:!1,value1:"",totalSize:0,totalCount:-1,CareWorktotalCount:-1,currentPage:1,CareWorkcurrentPage:1,curPageSize:10,disData:[{isDisabled:"1",name:"待派遣"},{isDisabled:"0",name:"全部"}],DdialogTitle:"",DdialogVisible:!1,DispatchedList:[]},s()(e,"tableLoading",!1),s()(e,"resourceSelection",[]),s()(e,"DRequestCode",""),s()(e,"DDateTime",""),s()(e,"DList",[]),e},mounted:function(){this.searchMission()},methods:{searchMission:function(){var e=this;this.tableLoading=!0,this.missionList=[],this.postRequestJson("/busi/mission/list",{name:this.patientName,projectId:this.$store.state.user.projectId,isDisabled:"1"===this.disData.isDisabled,curPage:this.currentPage,pageSize:this.curPageSize}).then(function(t){if(e.tableLoading=!1,!t||"200"!==t.data.code)return"200"===t.data.code?void e.$message({type:"fail",message:t.data.msg}):void e.$message({type:"fail",message:t});var a=t.data.msg;e.totalSize=a.totalSize;var i=a.result,s="";console.log(i);for(var r=0;r<i.length;r++){var l=!0;null==i[r].missionDate&&null==i[r].requestEndDate?s="待派遣":null!=i[r].missionDate&&null==i[r].requestEndDate?s="服务中":null!=i[r].requestEndDate&&(s="已结束",l=!1),e.missionList.push({patientName:i[r].patientName,patientCode:i[r].patientCode,orgName:i[r].orgName,requestCode:i[r].requestCode,hospitalizedDate:i[r].hospitalizedDate,serviceDate:i[r].requestStartDate,serviceType:i[r].careTypePorperty,price:i[r].careTypePrice,serviceName:i[r].careTypeName,serviceTai:s,serviceStatus:l})}})},SelectionChange:function(e){this.resourceSelection=e},showDispatched:function(e){this.DdialogTitle="派遣任务",this.DdialogVisible=!0,this.DRequestCode=e.requestCode,this.getCareWork(),this.getCareWorkByRecode(e.requestCode)},CloseDispatched:function(e){var t=this;this.deleteRequest("/busi/mission?requestCode="+e.requestCode).then(function(e){t.tableLoading=!1,e&&200===e.status?t.getMsage(e.data.msg):t.getMsage(e.status)})},getCareWorkByRecode:function(e){var t=this;this.postRequestJson("/busi/mission/detail",{requestCode:e}).then(function(e){t.tableLoading=!1,e&&200===e.status?"200"===e.data.code?t.DList=e.data.msg.result:t.getMsage(e.data.msg):t.getMsage(e.status)})},getCareWorkChean:function(e){this.CareWorkcurrentPage=e,this.getCareWork()},getCareWork:function(){var e=this;this.tableLoading=!0,this.postRequestJson("/busi/careworker/list",{name:this.carreName,curPage:this.CareWorkcurrentPage,pageSize:10}).then(function(t){e.tableLoading=!1,t&&200===t.status?"200"===t.data.code?(e.DispatchedList=t.data.msg.result,e.CareWorktotalCount=t.data.msg.totalSize):e.getMsage(t.data.msg):e.getMsage(t.status)})},missionClick:function(){var e=this;if(""!==this.DDateTime)if(0!==this.resourceSelection.length){for(var t=[],a=0;a<this.resourceSelection.length;a++)t.push(this.resourceSelection[a].careworkerId);this.postRequestJson("/busi/mission",{careworkerIds:t,requestCode:this.DRequestCode,dateTime:this.DDateTime,clerk:this.user.name}).then(function(t){e.tableLoading=!1,t&&200===t.status?"200"===t.data.code?(e.getMsage("派遣成功"),e.DdialogVisible=!1):e.getMsage(t.data.msg):e.getMsage(t.status)})}else this.getMsage("请选择派遣护工，注意：已派遣的护工不能派遣");else this.getMsage("派遣时间不能为空")},getMsage:function(e){var t=this;this.$confirm(e,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.searchMission()}).catch(function(){})}},computed:{user:function(){return this.$store.state.user}}},l={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-form",{staticClass:"demo-form-inline",staticStyle:{"margin-top":"10px"},attrs:{inline:!0}},[a("el-row",[a("el-form-item",{staticStyle:{float:"left"},attrs:{label:"病人姓名:",prop:"username"}},[a("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入病人姓名"},model:{value:e.patientName,callback:function(t){e.patientName=t},expression:"patientName"}})],1),e._v(" "),a("el-form-item",{staticStyle:{float:"left"},attrs:{label:"派工状态:",prop:"username"}},[a("el-select",{staticStyle:{width:"150px"},attrs:{size:"mini",placeholder:"派工状态"},model:{value:e.disData.isDisabled,callback:function(t){e.$set(e.disData,"isDisabled",t)},expression:"disData.isDisabled"}},e._l(e.disData,function(e){return a("el-option",{key:e.isDisabled,attrs:{label:e.name,value:e.isDisabled}})}),1)],1),e._v(" "),a("el-form-item",{staticStyle:{float:"left"}},[a("el-button",{attrs:{size:"mini",icon:"el-icon-search",type:"primary"},on:{click:e.searchMission}},[e._v("查询")])],1)],1),e._v(" "),a("el-row",[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.missionList,border:"",stripe:"",size:"mini"}},[a("el-table-column",{attrs:{prop:"patientName",align:"center",fixed:"",label:"病人姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"patientCode",align:"center",fixed:"",label:"病人编号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"orgName",align:"center",label:"现在科室"}}),e._v(" "),e.hideRow?a("el-table-column",{attrs:{prop:"requestCode",align:"center",label:"服务编号"}}):e._e(),e._v(" "),a("el-table-column",{attrs:{prop:"hospitalizedDate",label:"入院时间",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"serviceDate",label:"服务开始时间",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"serviceName",label:"服务名称",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"serviceTai",label:"服务状态",align:"center"}}),e._v(" "),e._e(),e._v(" "),a("el-table-column",{attrs:{prop:"serviceType",label:"服务类型",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"price",label:"服务单价",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.serviceStatus?a("el-button",{staticStyle:{padding:"3px 10px 3px 10px",margin:"2px"},attrs:{size:"small"},on:{click:function(a){return e.showDispatched(t.row)}}},[e._v("派遣操作\n            ")]):e._e(),e._v(" "),t.row.serviceStatus?a("el-button",{staticStyle:{padding:"3px 10px 3px 10px",margin:"2px"},attrs:{size:"small"},on:{click:function(a){return e.CloseDispatched(t.row)}}},[e._v("取消派遣\n            ")]):e._e()]}}])})],1),e._v(" "),a("el-pagination",{attrs:{"current-page":e.currentPage,"page-size":e.curPageSize,layout:"prev, pager, next, jumper",total:e.totalSize},on:{"current-change":e.searchMission,"update:currentPage":function(t){e.currentPage=t},"update:current-page":function(t){e.currentPage=t}}})],1)],1),e._v(" "),a("el-form",{ref:"DispatchedForm",staticStyle:{margin:"0px",padding:"0px"}},[a("div",{staticStyle:{"text-align":"left"}},[a("el-dialog",{staticStyle:{padding:"10px"},attrs:{title:e.DdialogTitle,"close-on-click-modal":!1,visible:e.DdialogVisible,width:"60%"},on:{"update:visible":function(t){e.DdialogVisible=t}}},[a("el-row",[a("el-form-item",{staticStyle:{"margin-top":"-30px"},attrs:{label:"已派遣护工"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{border:"",data:e.DList,stripe:"",height:"120",size:"mini"}},[a("el-table-column",{attrs:{prop:"careworkerCode",align:"center",fixed:"",label:"护工编号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"careworkerName",align:"center",label:"护工名称"}}),e._v(" "),a("el-table-column",{attrs:{prop:"missionDate",label:"派遣时间",align:"center"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"护工姓名:"}},[a("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",size:"mini",placeholder:"请输入护工姓名"},model:{value:e.carreName,callback:function(t){e.carreName=t},expression:"carreName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:5}},[a("el-form-item",[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:e.getCareWork}},[e._v("查询")])],1)],1)],1),e._v(" "),a("el-row",[a("el-form-item",{staticStyle:{"margin-top":"-30px"},attrs:{label:"未派遣护工"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%",height:"200px"},attrs:{border:"",data:e.DispatchedList,stripe:"",height:"200",size:"mini"},on:{"selection-change":e.SelectionChange}},[a("el-table-column",{attrs:{type:"selection",align:"left",width:"30"}}),e._v(" "),e.hideRow?a("el-table-column",{attrs:{prop:"careworkerId",label:"陪护人员记录号",align:"center"}}):e._e(),e._v(" "),a("el-table-column",{attrs:{prop:"code",align:"center",fixed:"",label:"护工编号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",align:"center",label:"护工名称"}}),e._v(" "),a("el-table-column",{attrs:{prop:"orgName",align:"center",label:"所属科室"}}),e._v(" "),a("el-table-column",{attrs:{prop:"startDateTime",label:"入职时间",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"endDateTime",label:"离职时间",align:"center"}})],1)],1),e._v(" "),a("div",{staticStyle:{display:"flex","justify-content":"space-between",margin:"2px",float:"right"}},[a("el-pagination",{attrs:{background:"","page-size":10,"current-page":e.CareWorkcurrentPage,layout:"prev, pager, next",total:e.CareWorktotalCount},on:{"current-change":e.getCareWorkChean}})],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"执行派工时间:",prop:"username"}},[a("div",{staticClass:"block"},[a("el-date-picker",{staticStyle:{width:"180px"},attrs:{type:"datetime","value-format":"yyyy-MM-dd HH:mm:ss",size:"mini",placeholder:"选择日期"},model:{value:e.DDateTime,callback:function(t){e.DDateTime=t},expression:"DDateTime"}})],1)])],1),e._v(" "),a("el-col",{attrs:{span:5}},[a("el-form-item",[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:e.missionClick}},[e._v("执行派工")])],1)],1)],1)],1)],1)])],1)},staticRenderFns:[]};var n=a("VU/8")(r,l,!1,function(e){a("GzbA")},"data-v-42e9916a",null);t.default=n.exports}});
//# sourceMappingURL=7.1e374724af9bf74b73e5.js.map