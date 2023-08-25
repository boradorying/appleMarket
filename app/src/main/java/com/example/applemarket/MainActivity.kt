package com.example.applemarket



import android.app.Activity
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent

import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val items: MutableList<Product> = mutableListOf()
    private lateinit var rvAdapter: RVAdapter

    companion object {
        const val DETAIL_PAGE_REQUEST_CODE = 123
        const val RESULT_OK = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.notificationArea.setOnClickListener {
            notification()
        }
        setContentView(binding.root)

        val items = mutableListOf<Product>()
        val product1 = Product(

            imageResourceId = R.drawable.sample1,
            productName = "산진 한달된 선풍기 팝니다",
            productDescription = "이사가서 필요가 없어졌어요 급하게 내놓습니다",
            seller = "대현동",
            price = "1,000원",
            address = "서울 서대문구 창천동",
            review = 13,
            like = 25
        )
        items.add(product1)
        val product2 = Product(

            imageResourceId = R.drawable.sample2,
            productName = "김치냉장고",
            productDescription = "이사로인해 내놔요",
            seller = "안마담",
            price = "20,000원",
            address = "인천 계양구 귤현동",
            review = 8,
            like = 28
        )
        items.add(product2)
        val product3 = Product(

            imageResourceId = R.drawable.sample3,
            productName = "샤넬 카드지갑",
            productDescription = "고퀄지갑이구요\n사용감이 있어서 싸게 내어둡니다",
            seller = "코코유",
            price = "10,000원",
            address = "수성구 범어동",
            review = 23,
            like = 5
        )
        items.add(product3)
        val product4 = Product(

            imageResourceId = R.drawable.sample4,
            productName = "금고",
            productDescription = "금고\n떼서 가져가야함\n대우월드마크센텀\n미국이주관계로 싸게 팝니다",
            seller = "Nicole",
            price = "100,000원",
            address = "해운대구 우제2동",
            review = 14,
            like = 17
        )
        items.add(product4)
        val product5 = Product(

            imageResourceId = R.drawable.sample5,
            productName = "갤럭시Z플립3 팝니다",
            productDescription = "갤럭시 Z플립3 그린 팝니다\n항시 케이스 씌워서 썻고 필름 한장챙겨드립니다\n화면에 살짝 스크래치난거 말고 크게 이상은없습니다!",
            seller = "절명",
            price = "150,000원",
            address = "연제구 연산제8동",
            review = 22,
            like = 85
        )
        items.add(product5)

        val product6 = Product(

            imageResourceId = R.drawable.sample6,
            productName = "프라다 복조리백",
            productDescription = "까임 오염없고 상태 깨끗합니다\n정품여부모름",
            seller = "미니멀하게",
            price = "500,000원",
            address = "수원시 영통구 원천동",
            review = 14,
            like = 25
        )
        items.add(product6)
        val product7 = Product(

            imageResourceId = R.drawable.sample7,
            productName = "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장별장별장별장별장별장별장별장별장",
            productDescription = "울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\n2. 장소: 북구 블루마시티, 32-33층\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\n6. 고기 굽기 가능\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\n8. 층간소음 주의 부탁드립니다.\n9. 방3개, 화장실3개, 비데 3개\n10. 저희 집안이 쓰는 별장입니다.",
            seller = "굿리치",
            price = "500,000원",
            address = "남구 옥동",
            review = 142,
            like = 54
        )
        items.add(product7)
        val product8 = Product(

            imageResourceId = R.drawable.sample8,
            productName = "프라다 샤넬 탑핸들 가방",
            productDescription = "샤넬 트랜디 CC 탑핸들 스몰 램스킨 블랙 금장 플랩백 !\n색상 : 블랙\n사이즈 : 25.5cm * 17.5cm * 8cm\n구성 : 본품더스트\n\n급하게 돈이 필요해서 팝니다 ㅠ ㅠ",
            seller = "난쉽",
            price = "1,500,000원",
            address = "동래구 온천제2동",
            review = 31,
            like = 7
        )
        items.add(product8)

        val product9 = Product(

            imageResourceId = R.drawable.sample9,
            productName = "4행정 엔진분무기 판매합니다.",
            productDescription = "3년전에 사서 한번 사용하고 그대로 둔 상태입니다. 요즘 사용은 안해봤습니다. 그래서 저렴하게 내 놓습니다. 중고라 반품은 어렵습니다.\\n",
            seller = "알뜰한",
            price = "30,000",
            address = "원주시 명륜2동",
            review = 7,
            like = 28
        )
        items.add(product9)


        val rvAdapter = RVAdapter(items, object : RVAdapter.OnItemClickListener {
            override fun onItemClick(
                imageResourceId: Int,
                productName: String,
                productDescription: String,
                seller: String,
                price: String,
                address: String
            ) {
                val intent = Intent(this@MainActivity, DetailPageActivity::class.java)
                intent.putExtra("IMAGE", imageResourceId)
                intent.putExtra("NAME", productName)
                intent.putExtra("DESCRIP", productDescription)
                intent.putExtra("SELLER", seller)
                intent.putExtra("PRICE", price)
                intent.putExtra("ADDRESS", address)




                startActivityForResult(intent, DETAIL_PAGE_REQUEST_CODE)

            }
        })

        rvAdapter.setOnItemLongClickListener(object : RVAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int) {
                showDeleteConfirmationDialog(position)
            }
        })

        binding.RVArea.layoutManager = LinearLayoutManager(this)
        binding.RVArea.adapter = rvAdapter
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        binding.RVArea.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0 && binding.floatingBtn.visibility != View.VISIBLE) {
                    binding.floatingBtn.show()
                    binding.floatingBtn.startAnimation(fadeIn)
                } else if (dy < 0 && binding.floatingBtn.visibility == View.VISIBLE) {
                    binding.floatingBtn.hide()
                    binding.floatingBtn.startAnimation(fadeOut)
                }
            }
        })
        binding.floatingBtn.setOnClickListener {
            scrollToTop()
        }

    }









    private fun showDeleteConfirmationDialog(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("상품 삭제")
        builder.setIcon(R.drawable.back)
        builder.setMessage("상품을 정말로 삭제하시겠습니까?")
        builder.setPositiveButton("확인") { dialog,which ->

            items.removeAt(position)
            rvAdapter.notifyItemRemoved(position)

        }
        builder.setNegativeButton("취소") { dialog, which ->

            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }





    fun scrollToTop() {
        binding.RVArea.smoothScrollToPosition(0)
    }

    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channelId = "one-channel"
            val channelName = "당근마케떠"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {

                description = "클론코딩당근마켓입니다"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }

            manager.createNotificationChannel(channel)


            builder = NotificationCompat.Builder(this, channelId)

        } else {

            builder = NotificationCompat.Builder(this)
        }

        val bitmap =
            BitmapFactory.decodeResource(resources, R.drawable.baseline_notifications_none_24)
        val intent = Intent(this, SampleActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        builder.run {
            setSmallIcon(R.drawable.baseline_notifications_none_24)
            setWhen(System.currentTimeMillis())
            setContentTitle("감자마케또")
            setContentText("키워드 알림\n설정한 키워드에 대한 알림이 도착했습니다!!!!!!!!")

            setLargeIcon(bitmap)

            addAction(R.drawable.baseline_notifications_none_24, "Action", pendingIntent)
        }

        manager.notify(11, builder.build())
    }

    override fun onBackPressed() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("종료")
        builder.setIcon(R.drawable.back)
        builder.setMessage("정말  종료하시겠습니까?")
        builder.setPositiveButton("확인", { dialog, which ->

            finish()
        })
        builder.setNegativeButton("취소", { dialog, which ->

            dialog.dismiss()
        })
        val dialog = builder.create()
        dialog.show()
    }
}
