// define a mixin object
export default {
  // This is called once the object is built.
  created: function () {
    console.log('mymixin has been created.')
    this.showMixinAlert()
  },
  // This is the method.
  methods: {
    showMixinAlert: function () {
      alert('Hi this is from mymixin!')
    },
    assignFullName: function () {
      this.fullname = 'Matthew Simpson'
    }
  },
  data () {
    return {
      mixinMsg: 'Hello from mixin',
      fullname: null,
      footwear: [
        {
          id: 100,
          shoe: 'Analeigh Suede Peeptoe Shooties ',
          brand: 'Ann Taylor'
        },

        {
          id: 200,
          shoe: 'Karen Millen Mesh and Leather Pumps ',
          brand: 'Karen Millen'
        },

        { id: 300, shoe: 'Olivia Suede Boots', brand: 'Joie' }
      ]
    }
  }
}
