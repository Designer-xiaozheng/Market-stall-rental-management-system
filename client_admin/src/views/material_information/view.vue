<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','item_no') || $check_field('add','item_no') || $check_field('set','item_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资编号" prop="item_no">
												<el-input id="item_no" v-model="form['item_no']" placeholder="请输入物资编号"
							  v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','item_no')) || (!form['material_information_id'] && $check_field('add','item_no'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','item_no')">{{form['item_no']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','item_name') || $check_field('add','item_name') || $check_field('set','item_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资名称" prop="item_name">
												<el-input id="item_name" v-model="form['item_name']" placeholder="请输入物资名称"
							  v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','item_name')) || (!form['material_information_id'] && $check_field('add','item_name'))" :disabled="disabledObj['item_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','item_name')">{{form['item_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','material_category') || $check_field('add','material_category') || $check_field('set','material_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资类别" prop="material_category">
								<el-select id="material_category" v-model="form['material_category']"
						v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','material_category')) || (!form['material_information_id'] && $check_field('add','material_category'))">
						<el-option v-for="o in list_material_category" :key="o['material_category']" :label="o['material_category']"
							:value="o['material_category']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','material_category')">{{form['material_category']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','brand') || $check_field('add','brand') || $check_field('set','brand')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="品牌" prop="brand">
												<el-input id="brand" v-model="form['brand']" placeholder="请输入品牌"
							  v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','brand')) || (!form['material_information_id'] && $check_field('add','brand'))" :disabled="disabledObj['brand_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','brand')">{{form['brand']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','specifications') || $check_field('add','specifications') || $check_field('set','specifications')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="规格" prop="specifications">
												<el-input id="specifications" v-model="form['specifications']" placeholder="请输入规格"
							  v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','specifications')) || (!form['material_information_id'] && $check_field('add','specifications'))" :disabled="disabledObj['specifications_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','specifications')">{{form['specifications']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','picture') || $check_field('add','picture') || $check_field('set','picture')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图片" prop="picture">
								<el-upload :disabled="disabledObj['picture_isDisabled']" id="picture" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_picture"
						:show-file-list="false" v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','picture')) || (!form['material_information_id'] && $check_field('add','picture'))">
						<img v-if="form['picture']" :src="$fullUrl(form['picture'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','picture')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['picture'])" :preview-src-list="[$fullUrl(form['picture'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','stock') || $check_field('add','stock') || $check_field('set','stock')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="库存" prop="stock">
								<el-input-number id="stock" v-model.number="form['stock']"
						v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','stock')) || (!form['material_information_id'] && $check_field('add','stock'))" :disabled="disabledObj['stock_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','stock')">{{form['stock']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','date_of_manufacture') || $check_field('add','date_of_manufacture') || $check_field('set','date_of_manufacture')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="生产日期" prop="date_of_manufacture">
								<el-date-picker :disabled="disabledObj['date_of_manufacture_isDisabled']" v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','date_of_manufacture')) || (!form['material_information_id'] && $check_field('add','date_of_manufacture'))" id="date_of_manufacture"
						v-model="form['date_of_manufacture']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','date_of_manufacture')">{{form['date_of_manufacture']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','term_of_validity') || $check_field('add','term_of_validity') || $check_field('set','term_of_validity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="有效期" prop="term_of_validity">
												<el-input id="term_of_validity" v-model="form['term_of_validity']" placeholder="请输入有效期"
							  v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','term_of_validity')) || (!form['material_information_id'] && $check_field('add','term_of_validity'))" :disabled="disabledObj['term_of_validity_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','term_of_validity')">{{form['term_of_validity']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','material_use') || $check_field('add','material_use') || $check_field('set','material_use')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资用途" prop="material_use">
								<el-input type="textarea" id="material_use" v-model="form['material_use']" placeholder="请输入物资用途"
						v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','material_use')) || (!form['material_information_id'] && $check_field('add','material_use'))" :disabled="disabledObj['material_use_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','material_use')">{{form['material_use']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','material_introduction') || $check_field('add','material_introduction') || $check_field('set','material_introduction')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资介绍" prop="material_introduction">
								<el-input type="textarea" id="material_introduction" v-model="form['material_introduction']" placeholder="请输入物资介绍"
						v-if="user_group === '管理员' || (form['material_information_id'] && $check_field('set','material_introduction')) || (!form['material_information_id'] && $check_field('add','material_introduction'))" :disabled="disabledObj['material_introduction_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','material_introduction')">{{form['material_introduction']}}</div>
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
				field: "material_information_id",
				url_add: "~/api/material_information/add?",
				url_set: "~/api/material_information/set?",
				url_get_obj: "~/api/material_information/get_obj?",
				url_upload: "~/api/material_information/upload?",

				query: {
					"material_information_id": 0,
				},

				form: {
								"item_no": this.$get_stamp(), // 物资编号
										"item_name":  '', // 物资名称
										"material_category":  '', // 物资类别
										"brand":  '', // 品牌
										"specifications":  '', // 规格
										"picture":  '', // 图片
										"stock":  0, // 库存
										"date_of_manufacture":  '', // 生产日期
										"term_of_validity":  '', // 有效期
										"material_use":  '', // 物资用途
										"material_introduction":  '', // 物资介绍
											"material_information_id": 0, // ID
						
				},
				disabledObj:{
								"item_no_isDisabled": false,
										"item_name_isDisabled": false,
										"material_category_isDisabled": false,
										"brand_isDisabled": false,
										"specifications_isDisabled": false,
										"picture_isDisabled": false,
					          			"stock_isDisabled": false,
										"date_of_manufacture_isDisabled": false,
										"term_of_validity_isDisabled": false,
										"material_use_isDisabled": false,
										"material_introduction_isDisabled": false,
										},

	
		
						// 物资类别选项列表
				list_material_category: [""],
	
		
		
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
				/**
			 * 获取物资类别列表
			 */
			async get_list_material_category() {
				var json = await this.$get("~/api/material_classification/get_list?");
				if(json.result && json.result.list){
					this.list_material_category = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
						/**
			 * 上传图片
			 * @param {Object} param 图片参数
			 */
			upload_picture(param){
						this.uploadFile(param.file, "picture");
					},
	
	
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
											
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
																        if (this.form["date_of_manufacture"].indexOf("-")===-1){
          this.form["date_of_manufacture"] = this.$toTime(parseInt(this.form["date_of_manufacture"]),"yyyy-MM-dd")
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


																							        if(this.form["date_of_manufacture"]=="0000-00-00"){
          this.form["date_of_manufacture"] = null;
        }
				if(parseInt(this.form["date_of_manufacture"]) > 9999){
					this.form["date_of_manufacture"] = this.$toTime(parseInt(this.form["date_of_manufacture"]),"yyyy-MM-dd")
				}
											

			},


			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/material_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material_information/view','get');
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
								this.get_list_material_category();
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
