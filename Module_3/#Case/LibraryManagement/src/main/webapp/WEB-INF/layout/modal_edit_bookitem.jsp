<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: smeenguyen
  Date: 15/01/2023
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="bookItemModal" tabindex="-1" aria-labelledby="bookItemModalLabel"
     style="display: none;" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="bookItemModalLabel">
          Chỉnh sửa sách mượn
        </h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"
                aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="col-lg-12">
          <form id="bItemForm"  method="post">
            <div class="card">
              <div class="card-body">
                <div class="row">
                  <div class="mb-3 col-sm-6">
                    <label for="inputPublisher" class="col-form-label">Nhà
                      XB</label>
                    <div>
                      <input required name="bItemPublisher"
                             id="inputPublisher" type="text"
                             class="form-control" value="">
                    </div>
                  </div>
                  <div class="mb-3 col-sm-6">
                    <label for="inputDayPublished" class="col-form-label">Ngày
                      XB</label>
                    <div class="">
                      <input required name="bItemPublishedDate"
                             id="inputDayPublished" type="date"
                             class="form-control" value="">
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="mb-3 col-sm-6">
                    <label for="inputPage" class="col-form-label">Số
                      trang</label>
                    <div class="">
                      <input required name="bItemPages" id="inputPage"
                             type="number" class="form-control" value="">
                    </div>
                  </div>
                  <div class="mb-3 col-sm-6">
                    <label for="inputPrice" class="col-form-label">Giá
                      mượn</label>
                    <div class="">
                      <input required name="bItemPrice" id="inputPrice"
                             type="number" class="form-control" value="">
                    </div>
                  </div>
                </div>
                <div class="row mb-3">
                  <div class="col-sm-6">
                    <label for="inputFormat" class="col-form-label">Định
                      dạng</label>
                    <div class="">
                      <select id="inputFormat" class="form-select" required
                              name="bItemFormat"
                              aria-label="Default select example">
                        <option selected="">
                          Định
                          dạng
                          sách
                        </option>
                        <c:forEach
                                items="${applicationScope['bookFormats']}"
                                var="bookFormat">
                          <option value="${bookFormat.getKey()}">${bookFormat.getValue()}</option>
                        </c:forEach>

                      </select>
                    </div>
                  </div>
                  <div class="col-sm-6">
                    <label for="inputQuantity" class="col-form-label">Số
                      lượng</label>
                    <div class="">
                      <input required name="bItemQuantity" id="inputQuantity"
                             type="number" class="form-control" value="">
                    </div>
                  </div>
                </div>
                <div class="row mb-3 col-sm-12">
                  <label class="col-form-label col-sm-3 pt-0">
                    Trạng
                    thái
                  </label>
                  <div class="form-control col-sm-12">
                    <div class="form-check col-sm-6">
                      <input required class="form-check-input" type="radio"
                             name="bIAvailable" id="bIavailable" value="true">
                      <label class="form-check-label" for="bIavailable">
                        Có
                        thể
                        mượn
                      </label>
                    </div>
                    <div class="form-check col-sm-6">
                      <input required class="form-check-input" type="radio"
                             name="bIAvailable" id="bINotAvailable"
                             value="false">
                      <label class="form-check-label" for="bINotAvailable">
                        Chưa
                        mượn
                      </label>
                    </div>
                  </div>
                </div>
                <input type="hidden" name="bookId" id="bItemBookId">
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="modal-footer">
        <button type="reset" form="bItemForm" class="btn btn-secondary" data-bs-dismiss="modal">
          Hủy
        </button>
        <button type="submit" form="bItemForm" class="btn btn-primary">
          Save changes
        </button>
      </div>
    </div>
  </div>
</div>