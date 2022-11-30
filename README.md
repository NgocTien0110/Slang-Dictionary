# CSC13002 – LẬP TRÌNH ỨNG DỤNG JAVA
# ĐỒ ÁN MÔN HỌC
# ĐỒ ÁN #1 – SLANG WORD

## I. Thông tin chung
Mã số bài tập: DAMH#1 <br>
Thời lượng dự kiến: 10 h  <br>
Deadline nộp bài: Moodle  <br>
Hình thức: Bài tập cá nhân  <br>
Hình thức nộp bài: Nộp qua Moodle môn học  <br>
GV phụ trách: Nguyễn Văn Khiết (LT), Nguyễn Đức Huy (TG) Hồ Tuấn Thanh (TH)  <br>
Thông tin liên lạc với GV: htthanh@fit.hcmus.edu.vn

## II. Chuẩn đầu ra cần đạt
Bài tập này nhằm mục tiêu đạt được các chuẩn đầu ra sau:
- G1.1: Thành lập, tổ chức, vận hành và quản lý nhóm
- G1.3: Phân tích, tổng hợp và viết tài liệu kỹ thuật theo mẫu cho trước theo cá
nhân hoặc cộng tác nhóm
- G4.2: Vận dụng được các cấu trúc dữ liệu cơ bản trong Java
- G4.4: Vận dụng được các cú pháp cơ bản trong Java
- G5.2: Vận dụng được Java IO để giải quyết bài toán đơn giản
- G5.6: Vận dụng được Collection để giải quyết bài toán đơn giản
- G5.8: Vận dụng Quản lý ngoại lệ trong bài toán đơn giản
- G6.1: Hình thành bài toán ban đầu
- G6.2: Phân tích bài toán đưa ra
- G6.3: Phân rã bài toán thành các tác vụ và lựa chọn công nghệ Java phù hợp để
cài đặt
- G7.1: Sử dụng các IDI hỗ trợ lập trình như Visual Studio Code, Eclipse, Netbeans
...

## III. Mô tả bài tập
Mục tiêu tài liệu tập trung vào các chủ đề: Java IO, Hướng đối tượng, Generic và
Collections. Sinh viên xây dựng một ứng dụng Slang Dictionary. Ứng dụng
Console/Swing/Java FX hỗ trợ các chức năng chính sau đây.

<b> Yêu cầu chung </b>

1. Phải sử dụng Java IO, OOP, Collections. Ứng dụng có thể là Console, Swing hoặc
Java FX.
2. Phải có menu để chọn chức năng, dù là ứng dụng console, hay GUI (Swing, Java
FX).
3. Load dữ liệu từ file và đưa vào cấu trúc dữ liệu đã tổ chức sẵn, nhằm tăng tốc độ tìm
kiếm. Đảm bảo có thể tìm kiếm nhanh (dưới 1s) cho trường hợp có đến 100.000 slang
words. Cấu trúc dữ liệu cần phải được lưu trữ lại, để các lần chạy chương trình tiếp theo, ko
cần tổ chức (index) lại dữ liệu.
4. Cần lưu danh sách slang word sau khi đã add, edit, delete.
5. Sử dụng Git (GitHub/Bitbucket/GitLab) để quản lí source code. Khi nộp bài, cần nộp
kèm hình chụp các lần commit. Phải có ít nhất 10 commit, nếu ít hơn sẽ 0d. Các commits
phải phân bố đều trong các ngày, tránh tình trạng toàn bộ các commit nằm trong 30 phút
cuối deadline.

<b>Các chức năng </b>

1. Chức năng tìm kiếm theo slang word.
2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong
defintion có chứa keyword gõ vào.
3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.
4. Chức năng add 1 slang words mới. Nếu slang words trùng thì thông báo cho người
dùng, confirm có overwrite hay duplicate ra 1 slang word mới.
5. Chức năng edit 1 slang word.
6. Chức năng delete 1 slang word. Confirm trước khi xoá.
7. Chức năng reset danh sách slang words gốc.
8. Chức năng random 1 slang word (On this day slang word).
9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho
người dùng chọn.
10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho
người dùng chọn.

## IV. Các yêu cầu & quy định chi tiết cho bài nộp

1. Đặt tên bài nộp có dạng MSSV_SoDiemTuDanhGia.zip.
2. Số điểm tự đánh giá, theo thang 100. Mỗi chức năng 10 điểm. Nếu chức năng chạy
chậm quá 1s, thì tự trừ 50% số điểm chức năng đó. Nếu giao diện chức năng đó ko tiện
dụng, thì tự trừ 30% số điểm chức năng đó. Dĩ nhiên, nếu chức năng đó chạy sai, thì ko có
điểm. Như vậy tối đa sinh viên sẽ có 100d.
3. Nếu sinh viên ko sử dụng cấu trúc dữ liệu gì khác, ngoài List, để đảm bảo thời gian
chạy của ứng dụng dưới 1s cho 100.000 slang words, thì điểm tối đa đồ án này chỉ là 70d.
4. Nếu sinh viên có dưới 10 commits và trải dài trong 5 ngày, thì điểm đồ án này là 0d.
5. Nếu sinh viên copy bài từ người khác, hoặc từ internet, thì 0d toàn bộ phần thực
hành và báo GVLT để xem xét 0d môn học.
6. Trường hợp có sử dụng nguồn từ người khác, hoặc từ internet, thì phải đánh dấu lại
trong code phần tham khảo và cho biết tổng phần trăm tham khảo trong toàn bộ đồ án.
7. Quay 1 video, upload lên Youtube bao gồm: mô tả ngắn gọn về cấu trúc dữ liệu sử
dụng, cho biết phần trăm tham khảo và demo toàn bộ 1 chức năng.
8. Bài nộp bao gồm <b> source code, file jar, file data, hình chụp commit, file txt có
phần chấm điểm cho từng chức năng và có chưa link video trên Youtube và đặt tên
đúng qui định. </b> Nếu ko, sẽ 0d đồ án này.