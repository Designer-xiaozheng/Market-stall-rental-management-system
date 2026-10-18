<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','item_no') || $check_field('add','item_no') || $check_field('set','item_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资编号" prop="item_no">
												<el-input id="item_no" v-model="form['item_no']" placeholder="请输入物资编号"
							  v-if="user_group === '管理员' || (form['material_warehousing_id'] && $check_field('set','item_no')) || (!form['material_warehousing_id'] && $check_field('add','item_no'))" :disabled="disabledObj['item_no_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','item_no')">{{form['item_no']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','item_name') || $check_field('add','item_name') || $check_field('set','item_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资名称" prop="item_name">
												<el-input id="item_name" v-model="form['item_name']" placeholder="请输入物资名称"
							  v-if="user_group === '管理员' || (form['material_warehousing_id'] && $check_field('set','item_name')) || (!form['material_warehousing_id'] && $check_field('add','item_name'))" :disabled="disabledObj['item_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','item_name')">{{form['item_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','brand') || $check_field('add','brand') || $check_field('set','brand')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="品牌" prop="brand">
												<el-input id="brand" v-model="form['brand']" placeholder="请输入品牌"
							  v-if="user_group === '管理员' || (form['material_warehousing_id'] && $check_field('set','brand')) || (!form['material_warehousing_id'] && $check_field('add','brand'))" :disabled="disabledObj['brand_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','brand')">{{form['brand']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','specifications') || $check_field('add','specifications') || $check_field('set','specifications')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="规格" prop="specifications">
												<el-input id="specifications" v-model="form['specifications']" placeholder="请输入规格"
							  v-if="user_group === '管理员' || (form['material_warehousing_id'] && $check_field('set','specifications')) || (!form['material_warehousing_id'] && $check_field('add','specifications'))" :disabled="disabledObj['specifications_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','specifications')">{{form['specifications']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','receipt_quantity') || $check_field('add','receipt_quantity') || $check_field('set','receipt_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="入库数量" prop="receipt_quantity">
								<el-input-number id="receipt_quantity" v-model.number="form['receipt_quantity']"
						v-if="user_group === '管理员' || (form['material_warehousing_id'] && $check_field('set','receipt_quantity')) || (!form['material_warehousing_id'] && $check_field('add','receipt_quantity'))" :disabled="disabledObj['receipt_quantity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','receipt_quantity')">{{form['receipt_quantity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','receipt_batch') || $check_field('add','receipt_batch') || $check_field('set','receipt_batch')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="入库批次" prop="receipt_batch">
												<el-input id="receipt_batch" v-model="form['receipt_batch']" placeholder="请输入入库批次"
							  v-if="user_group === '管理员' || (form['material_warehousing_id'] && $check_field('set','receipt_batch')) || (!form['material_warehousing_id'] && $check_field('add','receipt_batch'))" :disabled="disabledObj['receipt_batch_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','receipt_batch')">{{form['receipt_batch']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','warehousing_time') || $check_field('add','warehousing_time') || $check_field('set','warehousing_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="入库时间" prop="warehousing_time">
								<el-date-picker :disabled="disabledObj['warehousing_time_isDisabled']" v-if="user_group === '管理员' || (form['material_warehousing_id'] && $check_field('set','warehousing_time')) || (!form['material_warehousing_id'] && $check_field('add','warehousing_time'))" id="warehousing_time"
						v-model="form['warehousing_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','warehousing_time')">{{form['warehousing_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','manufacturer') || $check_field('add','manufacturer') || $check_field('set','manufacturer')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="生产商" prop="manufacturer">
												<el-input id="manufacturer" v-model="form['manufacturer']" placeholder="请输入生产商"
							  v-if="user_group === '管理员' || (form['material_warehousing_id'] && $check_field('set','manufacturer')) || (!form['material_warehousing_id'] && $check_field('add','manufacturer'))" :disabled="disabledObj['manufacturer_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','manufacturer')">{{form['manufacturer']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','warehousing_information') || $check_field('add','warehousing_information') || $check_field('set','warehousing_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="入库信息" prop="warehousing_information">
								<el-input type="textarea" id="warehousing_information" v-model="form['warehousing_information']" placeholder="请输入入库信息"
						v-if="user_group === '管理员' || (form['material_warehousing_id'] && $check_field('set','warehousing_information')) || (!form['material_warehousing_id'] && $check_field('add','warehousing_information'))" :disabled="disabledObj['warehousing_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','warehousing_information')">{{form['warehousing_information']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "material_warehousing_id",
				url_add: "~/api/material_warehousing/add?",
				url_set: "~/api/material_warehousing/set?",
				url_get_obj: "~/api/material_warehousing/get_obj?",
				url_upload: "~/api/material_warehousing/upload?",

				query: {
					"material_warehousing_id": 0,
				},

				form: {
								"item_no":  '', // 物资编号
										"item_name":  '', // 物资名称
										"brand":  '', // 品牌
										"specifications":  '', // 规格
										"receipt_quantity":  0, // 入库数量
										"receipt_batch":  '', // 入库批次
										"warehousing_time":  '', // 入库时间
										"manufacturer":  '', // 生产商
										"warehousing_information":  '', // 入库信息
											"material_warehousing_id": 0, // ID
						
				},
				disabledObj:{
								"item_no_isDisabled": false,
										"item_name_isDisabled": false,
										"brand_isDisabled": false,
										"specifications_isDisabled": false,
					          			"receipt_quantity_isDisabled": false,
										"receipt_batch_isDisabled": false,
										"warehousing_time_isDisabled": false,
										"manufacturer_isDisabled": false,
										"warehousing_information_isDisabled": false,
										},

	
		
		
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
												// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
								
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
														        if (this.form["warehousing_time"].indexOf("-")===-1){
          this.form["warehousing_time"] = this.$toTime(parseInt(this.form["warehousing_time"]),"yyyy-MM-dd")
        }
									$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																				        if(this.form["warehousing_time"]=="0000-00-00"){
          this.form["warehousing_time"] = null;
        }
				if(parseInt(this.form["warehousing_time"]) > 9999){
					this.form["warehousing_time"] = this.$toTime(parseInt(this.form["warehousing_time"]),"yyyy-MM-dd")
				}
								

			},


			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/material_warehousing/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material_warehousing/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material_warehousing/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material_warehousing/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material_warehousing/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
																				},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
