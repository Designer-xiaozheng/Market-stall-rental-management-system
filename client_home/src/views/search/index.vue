<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>

				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="应急知识"
				source_table="article"
			  ></list_result_search>


						  <list_result_search
				v-if="$check_action('/registered_users/list', 'get')"
				:list="result_registered_users_user_no"
				title="注册用户用户编号"
				source_table="registered_users"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/registered_users/list', 'get')"
				:list="result_registered_users_full_name"
				title="注册用户姓名"
				source_table="registered_users"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/material_classification/list', 'get')"
				:list="result_material_classification_material_category"
				title="物资分类物资类别"
				source_table="material_classification"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/material_information/list', 'get')"
				:list="result_material_information_item_name"
				title="物资信息物资名称"
				source_table="material_information"
			  ></list_result_search>
											  <list_result_search
				v-if="$check_action('/material_information/list', 'get')"
				:list="result_material_information_brand"
				title="物资信息品牌"
				source_table="material_information"
			  ></list_result_search>
																																	  <list_result_search
				v-if="$check_action('/material_application/list', 'get')"
				:list="result_material_application_item_name"
				title="物资申领物资名称"
				source_table="material_application"
			  ></list_result_search>
																				  <list_result_search
				v-if="$check_action('/material_application/list', 'get')"
				:list="result_material_application_full_name"
				title="物资申领姓名"
				source_table="material_application"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/material_warehousing/list', 'get')"
				:list="result_material_warehousing_item_name"
				title="物资入库物资名称"
				source_table="material_warehousing"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/material_warehousing/list', 'get')"
				:list="result_material_warehousing_brand"
				title="物资入库品牌"
				source_table="material_warehousing"
			  ></list_result_search>
																	  <list_result_search
				v-if="$check_action('/material_warehousing/list', 'get')"
				:list="result_material_warehousing_warehousing_time"
				title="物资入库入库时间"
				source_table="material_warehousing"
			  ></list_result_search>
												</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
						"result_registered_users_user_no":[],
								"result_registered_users_full_name":[],
									"result_material_classification_material_category":[],
												"result_material_information_item_name":[],
											"result_material_information_brand":[],
																																	"result_material_application_item_name":[],
																				"result_material_application_full_name":[],
																		"result_material_warehousing_item_name":[],
								"result_material_warehousing_brand":[],
																	"result_material_warehousing_warehousing_time":[],
										};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

				/**
	 * 获取user_no
	 */
	get_registered_users_user_no(){
		this.$get("~/api/registered_users/get_list?like=0", { page: 1, size: 10, "user_no": this.query.word }, (json) => {
		  if (json.result) {
			var result_registered_users_user_no = json.result.list;
			result_registered_users_user_no.map(o => o.title = o['user_no'])
	  			this.result_registered_users_user_no = result_registered_users_user_no
		 	}
		});
	},
						/**
	 * 获取full_name
	 */
	get_registered_users_full_name(){
		this.$get("~/api/registered_users/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_registered_users_full_name = json.result.list;
			result_registered_users_full_name.map(o => o.title = o['full_name'])
	  			this.result_registered_users_full_name = result_registered_users_full_name
		 	}
		});
	},
							/**
	 * 获取material_category
	 */
	get_material_classification_material_category(){
		this.$get("~/api/material_classification/get_list?like=0", { page: 1, size: 10, "material_category": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_classification_material_category = json.result.list;
			result_material_classification_material_category.map(o => o.title = o['material_category'])
	  			this.result_material_classification_material_category = result_material_classification_material_category
		 	}
		});
	},
										/**
	 * 获取item_name
	 */
	get_material_information_item_name(){
		this.$get("~/api/material_information/get_list?like=0", { page: 1, size: 10, "item_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_information_item_name = json.result.list;
			result_material_information_item_name.map(o => o.title = o['item_name'])
	  			this.result_material_information_item_name = result_material_information_item_name
		 	}
		});
	},
									/**
	 * 获取brand
	 */
	get_material_information_brand(){
		this.$get("~/api/material_information/get_list?like=0", { page: 1, size: 10, "brand": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_information_brand = json.result.list;
			result_material_information_brand.map(o => o.title = o['brand'])
	  			this.result_material_information_brand = result_material_information_brand
		 	}
		});
	},
																															/**
	 * 获取item_name
	 */
	get_material_application_item_name(){
		this.$get("~/api/material_application/get_list?like=0", { page: 1, size: 10, "item_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_application_item_name = json.result.list;
			result_material_application_item_name.map(o => o.title = o['item_name'])
	  			this.result_material_application_item_name = result_material_application_item_name
		 	}
		});
	},
																		/**
	 * 获取full_name
	 */
	get_material_application_full_name(){
		this.$get("~/api/material_application/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_application_full_name = json.result.list;
			result_material_application_full_name.map(o => o.title = o['full_name'])
	  			this.result_material_application_full_name = result_material_application_full_name
		 	}
		});
	},
																/**
	 * 获取item_name
	 */
	get_material_warehousing_item_name(){
		this.$get("~/api/material_warehousing/get_list?like=0", { page: 1, size: 10, "item_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_warehousing_item_name = json.result.list;
			result_material_warehousing_item_name.map(o => o.title = o['item_name'])
	  			this.result_material_warehousing_item_name = result_material_warehousing_item_name
		 	}
		});
	},
						/**
	 * 获取brand
	 */
	get_material_warehousing_brand(){
		this.$get("~/api/material_warehousing/get_list?like=0", { page: 1, size: 10, "brand": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_warehousing_brand = json.result.list;
			result_material_warehousing_brand.map(o => o.title = o['brand'])
	  			this.result_material_warehousing_brand = result_material_warehousing_brand
		 	}
		});
	},
															/**
	 * 获取warehousing_time
	 */
	get_material_warehousing_warehousing_time(){
		this.$get("~/api/material_warehousing/get_list?like=0", { page: 1, size: 10, "warehousing_time": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_warehousing_warehousing_time = json.result.list;
			result_material_warehousing_warehousing_time.map(o => o.title = o['warehousing_time'])
	  			this.result_material_warehousing_warehousing_time = result_material_warehousing_warehousing_time
		 	}
		});
	},
									
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
					this.get_registered_users_user_no();
							this.get_registered_users_full_name();
								this.get_material_classification_material_category();
											this.get_material_information_item_name();
										this.get_material_information_brand();
																																this.get_material_application_item_name();
																			this.get_material_application_full_name();
																	this.get_material_warehousing_item_name();
							this.get_material_warehousing_brand();
																this.get_material_warehousing_warehousing_time();
									  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
				  this.get_registered_users_user_no();
						  this.get_registered_users_full_name();
							  this.get_material_classification_material_category();
										  this.get_material_information_item_name();
									  this.get_material_information_brand();
																															  this.get_material_application_item_name();
																		  this.get_material_application_full_name();
																  this.get_material_warehousing_item_name();
						  this.get_material_warehousing_brand();
															  this.get_material_warehousing_warehousing_time();
										},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
