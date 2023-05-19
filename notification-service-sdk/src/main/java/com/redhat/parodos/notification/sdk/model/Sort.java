/*
 * Parodos Notification Service API
 * This is the API documentation for the Parodos Notification Service. It provides operations to send out and check notification. The endpoints are secured with oAuth2/OpenID and cannot be accessed without a valid token.
 *
 * The version of the OpenAPI document: v1.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.redhat.parodos.notification.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.redhat.parodos.notification.sdk.api.JSON;

/**
 * Sort
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Sort {

	public static final String SERIALIZED_NAME_EMPTY = "empty";

	@SerializedName(SERIALIZED_NAME_EMPTY)
	private Boolean empty;

	public static final String SERIALIZED_NAME_SORTED = "sorted";

	@SerializedName(SERIALIZED_NAME_SORTED)
	private Boolean sorted;

	public static final String SERIALIZED_NAME_UNSORTED = "unsorted";

	@SerializedName(SERIALIZED_NAME_UNSORTED)
	private Boolean unsorted;

	public Sort() {
	}

	public Sort empty(Boolean empty) {

		this.empty = empty;
		return this;
	}

	/**
	 * Get empty
	 * @return empty
	 **/
	@javax.annotation.Nullable

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}

	public Sort sorted(Boolean sorted) {

		this.sorted = sorted;
		return this;
	}

	/**
	 * Get sorted
	 * @return sorted
	 **/
	@javax.annotation.Nullable

	public Boolean getSorted() {
		return sorted;
	}

	public void setSorted(Boolean sorted) {
		this.sorted = sorted;
	}

	public Sort unsorted(Boolean unsorted) {

		this.unsorted = unsorted;
		return this;
	}

	/**
	 * Get unsorted
	 * @return unsorted
	 **/
	@javax.annotation.Nullable

	public Boolean getUnsorted() {
		return unsorted;
	}

	public void setUnsorted(Boolean unsorted) {
		this.unsorted = unsorted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Sort sort = (Sort) o;
		return Objects.equals(this.empty, sort.empty) && Objects.equals(this.sorted, sort.sorted)
				&& Objects.equals(this.unsorted, sort.unsorted);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empty, sorted, unsorted);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Sort {\n");
		sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
		sb.append("    sorted: ").append(toIndentedString(sorted)).append("\n");
		sb.append("    unsorted: ").append(toIndentedString(unsorted)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the
	 * first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public static HashSet<String> openapiFields;

	public static HashSet<String> openapiRequiredFields;

	static {
		// a set of all properties/fields (JSON key names)
		openapiFields = new HashSet<String>();
		openapiFields.add("empty");
		openapiFields.add("sorted");
		openapiFields.add("unsorted");

		// a set of required properties/fields (JSON key names)
		openapiRequiredFields = new HashSet<String>();
	}

	/**
	 * Validates the JSON Object and throws an exception if issues found
	 * @param jsonObj JSON Object
	 * @throws IOException if the JSON Object is invalid with respect to Sort
	 */
	public static void validateJsonObject(JsonObject jsonObj) throws IOException {
		if (jsonObj == null) {
			if (!Sort.openapiRequiredFields.isEmpty()) { // has required fields but JSON
															// object is null
				throw new IllegalArgumentException(
						String.format("The required field(s) %s in Sort is not found in the empty JSON string",
								Sort.openapiRequiredFields.toString()));
			}
		}

		Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
		// check to see if the JSON string contains additional fields
		for (Entry<String, JsonElement> entry : entries) {
			if (!Sort.openapiFields.contains(entry.getKey())) {
				throw new IllegalArgumentException(String.format(
						"The field `%s` in the JSON string is not defined in the `Sort` properties. JSON: %s",
						entry.getKey(), jsonObj.toString()));
			}
		}
	}

	public static class CustomTypeAdapterFactory implements TypeAdapterFactory {

		@SuppressWarnings("unchecked")
		@Override
		public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
			if (!Sort.class.isAssignableFrom(type.getRawType())) {
				return null; // this class only serializes 'Sort' and its subtypes
			}
			final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
			final TypeAdapter<Sort> thisAdapter = gson.getDelegateAdapter(this, TypeToken.get(Sort.class));

			return (TypeAdapter<T>) new TypeAdapter<Sort>() {
				@Override
				public void write(JsonWriter out, Sort value) throws IOException {
					JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
					elementAdapter.write(out, obj);
				}

				@Override
				public Sort read(JsonReader in) throws IOException {
					JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
					validateJsonObject(jsonObj);
					return thisAdapter.fromJsonTree(jsonObj);
				}

			}.nullSafe();
		}

	}

	/**
	 * Create an instance of Sort given an JSON string
	 * @param jsonString JSON string
	 * @return An instance of Sort
	 * @throws IOException if the JSON string is invalid with respect to Sort
	 */
	public static Sort fromJson(String jsonString) throws IOException {
		return JSON.getGson().fromJson(jsonString, Sort.class);
	}

	/**
	 * Convert an instance of Sort to an JSON string
	 * @return JSON string
	 */
	public String toJson() {
		return JSON.getGson().toJson(this);
	}

}
