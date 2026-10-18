<template>
	<div class="diy_edit page_material_application" id="material_application_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
						<div v-if="$check_field('set','item_no') || $check_field('add','item_no') || $check_field('get','item_no')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								物资编号:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_item_no" v-model="form['item_no']" placeholder="请输入物资编号" v-if="(form['item_no'] && $check_field('set','item_no')) || (!form['item_no'] && $check_field('add','item_no'))"  :disabled="disabledObj['item_no_isDisabled']"/>
							<span v-else-if="$check_field('get','item_no')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','item_name') || $check_field('add','item_name') || $check_field('get','item_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								物资名称:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_item_name" v-model="form['item_name']" placeholder="请输入物资名称" v-if="(form['item_name'] && $check_field('set','item_name')) || (!form['item_name'] && $check_field('add','item_name'))"  :disabled="disabledObj['item_name_isDisabled']"/>
							<span v-else-if="$check_field('get','item_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','brand') || $check_field('add','brand') || $check_field('get','brand')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								品牌:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_brand" v-model="form['brand']" placeholder="请输入品牌" v-if="(form['brand'] && $check_field('set','brand')) || (!form['brand'] && $check_field('add','brand'))"  :disabled="disabledObj['brand_isDisabled']"/>
							<span v-else-if="$check_field('get','brand')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','specifications') || $check_field('add','specifications') || $check_field('get','specifications')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								规格:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_specifications" v-model="form['specifications']" placeholder="请输入规格" v-if="(form['specifications'] && $check_field('set','specifications')) || (!form['specifications'] && $check_field('add','specifications'))"  :disabled="disabledObj['specifications_isDisabled']"/>
							<span v-else-if="$check_field('get','specifications')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','stock') || $check_field('add','stock') || $check_field('get','stock')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								库存:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_stock" v-model="form['stock']" placeholder="请输入库存" v-if="(form['stock'] && $check_field('set','stock')) || (!form['stock'] && $check_field('add','stock'))"  :disabled="disabledObj['stock_isDisabled']"/>
							<span v-else-if="$check_field('get','stock')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','user_no') || $check_field('add','user_no') || $check_field('get','user_no')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								用户编号:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_user_no" :disabled="disabledObj['user_no_isDisabled']" v-model="form['user_no']" v-if="(form['user_no'] && $check_field('set','user_no')) || (!form['user_no'] && $check_field('add','user_no'))" >
								<option v-for="o in list_user_user_no" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','user_no')">{{ form['user_no'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','full_name') || $check_field('add','full_name') || $check_field('get','full_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								姓名:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_full_name" v-model="form['full_name']" placeholder="请输入姓名" v-if="(form['full_name'] && $check_field('set','full_name')) || (!form['full_name'] && $check_field('add','full_name'))"  :disabled="disabledObj['full_name_isDisabled']"/>
							<span v-else-if="$check_field('get','full_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','application_quantity') || $check_field('add','application_quantity') || $check_field('get','application_quantity')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								申领数量:
							</span>
						</div>
								<!-- 数字 -->
						<div class="diy_field diy_number">
							<input type="number" id="form_application_quantity" v-model.number="form['application_quantity']" placeholder="请输入申领数量" v-if="(form['application_quantity'] && $check_field('set','application_quantity')) || (!form['application_quantity'] && $check_field('add','application_quantity'))" :disabled="disabledObj['application_quantity_isDisabled']" />
							<span v-else-if="$check_field('get','application_quantity')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','application_purpose') || $check_field('add','application_purpose') || $check_field('get','application_purpose')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								申领用途:
							</span>
						</div>
								<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_application_purpose" v-model="form['application_purpose']" v-if="(form['application_purpose'] && $check_field('set','application_purpose')) || (!form['application_purpose'] && $check_field('add','application_purpose'))" :disabled="disabledObj['application_purpose_isDisabled']" />
							<span v-else-if="$check_field('get','application_purpose')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
	


					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/material_application/edit','examine')">
							<!--<span> {{ form['examine_state'] }} </span>-->
							<select v-model="form['examine_state']">
								<option value="未审核">
									未审核
								</option>
								<option value="已通过">
									已通过
								</option>
								<option value="未通过">
									未通过
								</option>
							</select>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_state'] }}
							</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核回复:
							</span>
						</div>
						<div class="diy_field diy_desc" v-if="$check_action('/material_application/edit','examine')">
							<textarea v-model="form['examine_reply']"></textarea>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_reply'] }}
							</span>
						</div>
					</div>


				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/material_application/get_obj?",
				url_add: "~/api/material_application/add?",
				url_set: "~/api/material_application/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"item_no": "",
							"item_name": "",
							"brand": "",
							"specifications": "",
							"stock": "",
							"user_no": 0,
							"full_name": "",
							"application_quantity": 0,
							"application_purpose": "",
						"material_application_id": 0,
				},

				obj: {
						"item_no":  '', // 物资编号
							"item_name":  '', // 物资名称
							"brand":  '', // 品牌
							"specifications":  '', // 规格
							"stock":  '', // 库存
							"user_no": 0, // 用户编号
							"full_name":  '', // 姓名
							"application_quantity":  0, // 申领数量
							"application_purpose":  '', // 申领用途
						"examine_state": "未审核",
					"examine_reply": "",
					"material_application_id": 0,
				},

				// 表单字段
				form: {
						"item_no":  '', // 物资编号
							"item_name":  '', // 物资名称
							"brand":  '', // 品牌
							"specifications":  '', // 规格
							"stock":  '', // 库存
							"user_no": 0, // 用户编号
							"full_name":  '', // 姓名
							"application_quantity":  0, // 申领数量
							"application_purpose":  '', // 申领用途
						"examine_state": "未审核",
					"examine_reply": "",
					"material_application_id": 0,
				},
				disabledObj:{
						"item_no_isDisabled": false,
							"item_name_isDisabled": false,
							"brand_isDisabled": false,
							"specifications_isDisabled": false,
							"stock_isDisabled": false,
							"user_no_isDisabled": false,
							"full_name_isDisabled": false,
									"application_purpose_isDisabled": false,
					},

																// 用户列表
				list_user_user_no: [],
							
				// ID字段
				field: "material_application_id",

			}
		},
		methods: {
			
				
				
				
				
						/**
			 * 获取注册用户用户列表
			 */
			async get_list_user_user_no() {
				// if(this.user_group !== "管理员" && this.form["user_no"] === 0) {
				//     this.form["user_no"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=注册用户");
				if(json.result && json.result.list){
					this.list_user_user_no = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
					async get_user_session_user_no(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=注册用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["user_no"] = user_id
								_this.disabledObj['user_no' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "user_no") {
                          _this.form[arrForm[j]] = res.result.obj[arr[i]]
                          _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                          break;
                        }
                      }
                    }
                  }
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
				
				
				
	
			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/material_application/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
        //   this.obj = $.push(this.obj ,form);
				// 	this.form = $.push(this.form ,form);
				// }
				// var arr = []
				// for (let key in form) {
				// 	arr.push(key)
				// }
				// for (var i=0;i<arr.length;i++){
				// 	this.disabledObj[arr[i] + '_isDisabled'] = true
				// }
        if (form) {
          var arr = []
          for (let key in form) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arrForm[j] === arr[i]) {
                  this.form[arrForm[j]] = form[arr[i]]
                  this.obj[arrForm[j]] = form[arr[i]]
                  this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  break;
                }
              }
            }
          }
        }
																		
        $.db.del("form");
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				// var form = $.db.get("form");
				// var obj = Object.assign({} ,form ,this.obj);
				// if (obj) {
        //   delete(obj.examine_state)
        //   delete(obj.examine_reply)
				// 	this.obj = $.push(this.obj ,obj);
				// }
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
				// 	this.form = $.push(this.form ,form);
				// }
				if(func){
					func(json);
				}
			},

		},
		created() {
																				this.get_user_session_user_no();
					this.get_list_user_user_no();
												},
	}
</script>

<style>




</style>
